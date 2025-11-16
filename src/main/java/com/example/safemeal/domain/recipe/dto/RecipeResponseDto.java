package com.example.safemeal.domain.recipe.dto;

import com.example.safemeal.domain.recipe.entity.Recipe;
import com.example.safemeal.domain.review.dto.ReviewResponseDto;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecipeResponseDto {
    private Long id;
    private String name;
    private String category;
    private Integer kcal;
    private Integer carbohydrate;
    private Integer protein;
    private Integer fat;
    private Integer sodium;
    private String imgSmall;
    private String imgLarge;

    private List<CookManualResponseDto> manuals;
    private List<RecipeIngredientResponseDto> ingredients;
//    private List<ReviewResponseDto> reviews;


    public static RecipeResponseDto from(Recipe recipe) {
        return RecipeResponseDto.builder()
                .id(recipe.getTblKey())
                .name(recipe.getName())
                .category(recipe.getCategory())
                .kcal(recipe.getKcal())
                .carbohydrate(recipe.getCarbohydrate())
                .protein(recipe.getProtein())
                .fat(recipe.getFat())
                .sodium(recipe.getSodium())
                .imgSmall(recipe.getImgSmall())
                .imgLarge(recipe.getImgLarge())
                .manuals(recipe.getCookManuals().stream()
                        .map(CookManualResponseDto::from)
                        .collect(Collectors.toList()))
                .ingredients(recipe.getIngredients().stream()
                        .map(RecipeIngredientResponseDto::from)
                        .collect(Collectors.toList()))
//                .reviews(recipe.getReviews().stream()
//                        .map(ReviewResponseDto::from)
//                        .collect(Collectors.toList()))
                .build();
    }
}
