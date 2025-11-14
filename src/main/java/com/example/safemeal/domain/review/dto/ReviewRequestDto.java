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

    @NotBlank(message = "리뷰 내용은 필수입니다.")
    @Size(max = 1000)
    private String text;

    @NotBlank(message = "작성일자는 필수입니다. (yyyyMMddHHmmssfff)")
    @Size(max = 17)
    private String date;

    public Review toEntity(Recipe recipe) {
        return Review.builder()
                .text(this.text)
                .date(this.date)
                .recipe(recipe)
                .build();
    }

    public void updateEntity(Review review) {
        review.setText(this.text);
        review.setDate(this.date);
    }
}