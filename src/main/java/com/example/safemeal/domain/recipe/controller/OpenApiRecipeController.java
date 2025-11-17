package com.example.safemeal.domain.recipe.controller;

import com.example.safemeal.domain.recipe.service.OpenApiRecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/openapi")
@RequiredArgsConstructor
public class OpenApiRecipeController {

    private final OpenApiRecipeService openApiRecipeService;

    // OpenAPI 데이터 가져와서 DB 저장
    @PostMapping("/recipes")
    public ResponseEntity<String> importRecipes(
            @RequestParam(defaultValue = "1") int start,
            @RequestParam(defaultValue = "20") int end) {

        openApiRecipeService.fetchAndSaveRecipes(start, end);
        return ResponseEntity.ok("레시피 데이터 저장 완료 (" + start + "~" + end + ")");
    }
}