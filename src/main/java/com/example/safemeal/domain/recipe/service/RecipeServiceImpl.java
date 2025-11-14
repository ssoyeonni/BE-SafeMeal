package com.example.safemeal.domain.recipe.service;

import com.example.safemeal.domain.recipe.dto.RecipeIngredientResponseDto;
import com.example.safemeal.domain.recipe.dto.RecipeListResponseDto;
import com.example.safemeal.domain.recipe.dto.RecipeResponseDto;
import com.example.safemeal.domain.recipe.entity.Recipe;
import com.example.safemeal.domain.recipe.entity.RecipeIngredient;
import com.example.safemeal.domain.recipe.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    @Override
    public List<RecipeListResponseDto> getRecipeList() {
        return recipeRepository.findAll().stream()
                .map(RecipeListResponseDto::from)
                .toList();
    }

    @Override
    public RecipeResponseDto getRecipeDetail(Long id) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 레시피가 존재하지 않습니다."));
        return RecipeResponseDto.from(recipe);
    }
}