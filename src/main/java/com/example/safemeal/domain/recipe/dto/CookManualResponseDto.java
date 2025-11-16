package com.example.safemeal.domain.recipe.dto;

import com.example.safemeal.domain.recipe.entity.CookManual;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CookManualResponseDto {
    private Long id;
    private Integer cookOrder;
    private String cookMethod;

    public static CookManualResponseDto from(CookManual entity) {
        return CookManualResponseDto.builder()
                .id(entity.getTblKey())
                .cookOrder(entity.getCookOrder())
                .cookMethod(entity.getCookMethod())
                .build();
    }
}