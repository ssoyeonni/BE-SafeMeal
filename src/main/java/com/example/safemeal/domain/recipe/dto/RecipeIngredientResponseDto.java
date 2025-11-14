package com.example.safemeal.domain.recipe.dto;

import com.example.safemeal.domain.recipe.entity.RecipeIngredient;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecipeIngredientResponseDto {
    private Long id;
    private String name;
    private String linkUrl;

    public static RecipeIngredientResponseDto from(RecipeIngredient ingredient) {
        return RecipeIngredientResponseDto.builder()
                .id(ingredient.getTblKey())
                .name(ingredient.getName())
                .linkUrl(ingredient.getLinkUrl())
                .build();
    }
}