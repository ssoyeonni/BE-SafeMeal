package com.example.safemeal.domain.review.service;

import com.example.safemeal.domain.recipe.entity.Recipe;
import com.example.safemeal.domain.recipe.repository.RecipeRepository;
import com.example.safemeal.domain.review.dto.ReviewRequestDto;
import com.example.safemeal.domain.review.dto.ReviewResponseDto;
import com.example.safemeal.domain.review.entity.Review;
import com.example.safemeal.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final RecipeRepository recipeRepository;

    @Override
    public ReviewResponseDto createReview(ReviewRequestDto requestDto) {
        // 레시피 존재 여부 확인
        Recipe recipe = recipeRepository.findById(requestDto.getRecipeId())
                .orElseThrow(() -> new IllegalArgumentException("해당 레시피가 존재하지 않습니다."));

        Review saved = reviewRepository.save(requestDto.toEntity(recipe));
        return ReviewResponseDto.from(saved);
    }

    @Override
    public List<ReviewResponseDto> getReviewsByRecipe(Long recipeId) {
        return reviewRepository.findByRecipe_TblKey(recipeId)
                .stream()
                .map(ReviewResponseDto::from)
                .collect(Collectors.toList());
    }

    @Override
    public ReviewResponseDto updateReview(Long id, ReviewRequestDto updateDto) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 리뷰가 존재하지 않습니다."));

        updateDto.updateEntity(review);
        return ReviewResponseDto.from(reviewRepository.save(review));
    }

    @Override
    public void deleteReview(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 리뷰가 존재하지 않습니다."));
        reviewRepository.delete(review);
    }
}
