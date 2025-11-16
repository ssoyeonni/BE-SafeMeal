package com.example.safemeal.domain.recipe.entity;

import com.example.safemeal.global.base.BaseEntity;
import com.example.safemeal.domain.review.entity.Review;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RECIPE_INFO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recipe extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TBLKEY", nullable = false)
    private Long tblKey;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "CATEGORY", length = 4, nullable = false)
    private String category;

    @Column(name = "KCAL")
    private Integer kcal;

    @Column(name = "CARBOHYDRATE")
    private Integer carbohydrate;

    @Column(name = "PROTEIN")
    private Integer protein;

    @Column(name = "FAT")
    private Integer fat;

    @Column(name = "SODIUM")
    private Integer sodium; // mg 단위

    @Column(name = "IMG_SMALL", length = 200)
    private String imgSmall;

    @Column(name = "IMG_LARGE", length = 200)
    private String imgLarge;

    // 조리법 연결
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CookManual> cookManuals = new ArrayList<>();

    // 리뷰 연결
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    // 재료 연결
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecipeIngredient> ingredients = new ArrayList<>();
}