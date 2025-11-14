package com.example.safemeal.domain.recipe.service;

import com.example.safemeal.domain.recipe.dto.RecipeListResponseDto;
import com.example.safemeal.domain.recipe.dto.RecipeResponseDto;

import java.util.List;

public interface RecipeService {
    List<RecipeListResponseDto> getRecipeList();
    RecipeResponseDto getRecipeDetail(Long id);
}