package com.example.safemeal.domain.recipe.entity;

import com.example.safemeal.domain.recipe.entity.Recipe;
import com.example.safemeal.global.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "COOK_MANUAL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CookManual extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TBLKEY")
    private Long tblKey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RECIPE_ID", nullable = false)
    private Recipe recipe;

    @Column(name = "COOK_METHOD", length = 1000)
    private String cookMethod;

    @Column(name = "COOK_ORDER")
    private Integer cookOrder;
}