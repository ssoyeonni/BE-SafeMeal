package com.example.safemeal.domain.review.dto;

import com.example.safemeal.domain.recipe.entity.Recipe;
import com.example.safemeal.domain.review.entity.Review;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewRequestDto {

    @NotNull(message = "레시피 ID는 필수입니다.")
    private Long recipeId;

    @NotBlank(message = "작성자명은 필수입니다.")
    @Size(max = 50, message = "작성자명은 50자 이내여야 합니다.")
    private String userName;

    @NotBlank(message = "리뷰 내용은 필수입니다.")
    @Size(max = 1000)
    private String text;


    public Review toEntity(Recipe recipe) {
        return Review.builder()
                .userName(this.userName)
                .text(this.text)
                .recipe(recipe)
                .build();
    }

    public void updateEntity(Review review) {
        review.setText(this.text);
    }
}