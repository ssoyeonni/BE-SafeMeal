package com.example.safemeal.domain.recipe.dto;

import com.example.safemeal.domain.recipe.entity.Recipe;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecipeResponseDto {
    private Long id;
    private String name;
    private String category;
    private String kcal;
    private String carbohydrate;
    private String protein;
    private String fat;
    private String sodium;
    private String imgSmall;
    private String imgLarge;

    private List<RecipeIngredientResponseDto> ingredients;

    private String manual01;
    private String manual02;
    private String manual03;
    private String manual04;
    private String manual05;
    private String manual06;
    private String manual07;
    private String manual08;
    private String manual09;
    private String manual10;
    private String manual11;
    private String manual12;
    private String manual13;
    private String manual14;
    private String manual15;
    private String manual16;
    private String manual17;
    private String manual18;
    private String manual19;
    private String manual20;

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
                .ingredients(
                        recipe.getIngredientsList().stream()
                                .map(RecipeIngredientResponseDto::from)
                                .toList()
                )
                .manual01(recipe.getManual01())
                .manual02(recipe.getManual02())
                .manual03(recipe.getManual03())
                .manual04(recipe.getManual04())
                .manual05(recipe.getManual05())
                .manual06(recipe.getManual06())
                .manual07(recipe.getManual07())
                .manual08(recipe.getManual08())
                .manual09(recipe.getManual09())
                .manual10(recipe.getManual10())
                .manual11(recipe.getManual11())
                .manual12(recipe.getManual12())
                .manual13(recipe.getManual13())
                .manual14(recipe.getManual14())
                .manual15(recipe.getManual15())
                .manual16(recipe.getManual16())
                .manual17(recipe.getManual17())
                .manual18(recipe.getManual18())
                .manual19(recipe.getManual19())
                .manual20(recipe.getManual20())
                .build();
    }
}
