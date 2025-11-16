package com.example.safemeal.domain.recipe.entity;

import com.example.safemeal.global.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "RECIPE_INGREDIENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecipeIngredient extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TBLKEY", nullable = false)
    private Long tblKey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RECIPE_ID", nullable = false)
    private Recipe recipe;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "LINK_URL", length = 500)
    private String linkUrl;
}