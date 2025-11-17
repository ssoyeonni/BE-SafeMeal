package com.example.safemeal.domain.recipe.repository;


import com.example.safemeal.domain.recipe.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Query("SELECT r.name FROM Recipe r")
    List<String> findAllNames();
}