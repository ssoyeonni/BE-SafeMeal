package com.example.safemeal.domain.recipe.service;

import com.example.safemeal.domain.recipe.entity.*;
import com.example.safemeal.domain.recipe.repository.*;
import com.example.safemeal.global.api.FoodSafetyApiClient;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OpenApiRecipeService {

    private final FoodSafetyApiClient apiClient;
    private final RecipeRepository recipeRepository;
    private final RecipeIngredientRepository ingredientRepository;
    private final CookManualRepository manualRepository;


    // 레시피 기본 정보
    public void fetchAndSaveRecipes(int start, int end) {
        JsonNode rows = apiClient.fetchRecipes(start, end);

        // 기존 레시피명 전부 조회 (중복 체크용)
        List<String> existingNames = recipeRepository.findAllNames();

        int addedCount = 0;
        int skippedCount = 0;

        for (JsonNode item : rows) {
            String recipeName = item.path("RCP_NM").asText().trim();
            if (existingNames.contains(recipeName)) {
                skippedCount++;
                continue;
            }

            // 새 레시피만 저장
            Recipe recipe = Recipe.builder()
                    .name(recipeName)
                    .category(item.path("RCP_PAT2").asText())
                    .kcal(parseIntSafe(item.path("INFO_ENG").asText()))
                    .carbohydrate(parseIntSafe(item.path("INFO_CAR").asText()))
                    .protein(parseIntSafe(item.path("INFO_PRO").asText()))
                    .fat(parseIntSafe(item.path("INFO_FAT").asText()))
                    .sodium(parseIntSafe(item.path("INFO_NA").asText()))
                    .imgSmall(item.path("ATT_FILE_NO_MAIN").asText())
                    .imgLarge(item.path("ATT_FILE_NO_MK").asText())
                    .build();

            Recipe saved = recipeRepository.save(recipe);
            addedCount++;

            // 재료 저장
            String ingredients = item.path("RCP_PARTS_DTLS").asText().replace("\n", " ");
            if (!ingredients.isBlank()) {
                for (String part : ingredients.split(",")) {
                    ingredientRepository.save(
                            RecipeIngredient.builder()
                                    .recipe(saved)
                                    .name(part.trim())
                                    .build()
                    );
                }
            }

            // 조리법 저장
            for (int i = 1; i <= 20; i++) {
                String step = item.path("MANUAL" + String.format("%02d", i)).asText().trim();
                if (!step.isEmpty()) {
                    manualRepository.save(
                            CookManual.builder()
                                    .recipe(saved)
                                    .cookMethod(step)
                                    .cookOrder(i)
                                    .build()
                    );
                }
            }
        }

        System.out.println("OpenAPI 동기화 완료: 신규 " + addedCount + "건 추가, 기존 " + skippedCount + "건 유지");
    }

    private Integer parseIntSafe(String value) {
        try {
            return (int) Double.parseDouble(value);
        } catch (Exception e) {
            return null;
        }
    }

    private String getSafeText(JsonNode node, String field) {
        return node.has(field) && !node.path(field).isNull()
                ? node.path(field).asText().trim()
                : "";
    }
}