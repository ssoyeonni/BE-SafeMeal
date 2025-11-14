package com.example.safemeal.domain.recipe.controller;

import com.example.safemeal.domain.recipe.dto.RecipeListResponseDto;
import com.example.safemeal.domain.recipe.dto.RecipeResponseDto;
import com.example.safemeal.domain.recipe.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping
    public ResponseEntity<List<RecipeListResponseDto>> getRecipeList() {
        List<RecipeListResponseDto> recipes = recipeService.getRecipeList();
        return ResponseEntity.ok(recipes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeResponseDto> getRecipeDetail(@PathVariable Long id) {
        return ResponseEntity.ok(recipeService.getRecipeDetail(id));
    }
}