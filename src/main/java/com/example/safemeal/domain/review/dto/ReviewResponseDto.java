package com.example.safemeal.domain.review.dto;

import com.example.safemeal.domain.review.entity.Review;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewResponseDto {
    private Long id;
    private Long recipeId;
    private String text;
    private String date;

    public static ReviewResponseDto from(Review entity) {
        return ReviewResponseDto.builder()
                .id(entity.getTblKey())
                .text(entity.getText())
                .date(entity.getDate())
                .recipeId(entity.getRecipe().getTblKey())
                .build();
    }
}