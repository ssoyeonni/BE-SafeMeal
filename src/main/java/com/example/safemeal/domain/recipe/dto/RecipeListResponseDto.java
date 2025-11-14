package com.example.safemeal.domain.recipe.dto;

import com.example.safemeal.domain.recipe.entity.Recipe;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecipeListResponseDto {
    private Long id;
    private String name;
    private String category;
    private String kcal;
    private String imgSmall;

    public static RecipeListResponseDto from(Recipe recipe) {
        return RecipeListResponseDto.builder()
                .id(recipe.getTblKey())
                .name(recipe.getName())
                .category(recipe.getCategory())
                .kcal(recipe.getKcal())
                .imgSmall(recipe.getImgSmall())
                .build();
    }
}