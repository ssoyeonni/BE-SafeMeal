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
    private String userName;
    private String text;

    public static ReviewResponseDto from(Review entity) {
        return ReviewResponseDto.builder()
                .id(entity.getTblKey())
                .recipeId(entity.getRecipe().getTblKey())
                .userName(entity.getUserName())
                .text(entity.getText())
                .build();
    }
}