package com.example.safemeal.domain.review.service;

import com.example.safemeal.domain.review.dto.ReviewRequestDto;
import com.example.safemeal.domain.review.dto.ReviewResponseDto;

import java.util.List;

public interface ReviewService {
    ReviewResponseDto createReview(ReviewRequestDto requestDto);
    List<ReviewResponseDto> getReviewsByRecipe(Long recipeId);
    ReviewResponseDto updateReview(Long id, ReviewRequestDto updateDto);
    void deleteReview(Long id);
}