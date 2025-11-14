package com.example.safemeal.domain.review.controller;

import com.example.safemeal.domain.review.dto.ReviewRequestDto;
import com.example.safemeal.domain.review.dto.ReviewResponseDto;
import com.example.safemeal.domain.review.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/recipes/{recipeId}/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewResponseDto> createReview(@PathVariable Long recipeId, @Valid @RequestBody ReviewRequestDto requestDto) {
        requestDto.setRecipeId(recipeId);
        ReviewResponseDto response = reviewService.createReview(requestDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ReviewResponseDto>> getReviewsByRecipe(@PathVariable Long recipeId) {
        return ResponseEntity.ok(reviewService.getReviewsByRecipe(recipeId));
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<ReviewResponseDto> updateReview(@PathVariable Long reviewId, @Valid @RequestBody ReviewRequestDto updateDto) {
        return ResponseEntity.ok(reviewService.updateReview(reviewId, updateDto));
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
        return ResponseEntity.noContent().build();
    }
}
