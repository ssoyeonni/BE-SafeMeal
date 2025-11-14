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

    @Column(name = "CATEGORY", length = 50, nullable = false)
    private String category;

    @Column(name = "KCAL", length = 20)
    private String kcal;

    @Column(name = "CARBOHYDRATE", length = 20)
    private String carbohydrate;

    @Column(name = "PROTEIN", length = 20)
    private String protein;

    @Column(name = "FAT", length = 20)
    private String fat;

    @Column(name = "SODIUM", length = 20)
    private String sodium;

    @Column(name = "IMG_SMALL", length = 300)
    private String imgSmall;

    @Column(name = "IMG_LARGE", length = 300)
    private String imgLarge;

    // 만드는법 (1~20)
    @Column(name = "MANUAL01", length = 1000)
    private String manual01;
    @Column(name = "MANUAL02", length = 1000)
    private String manual02;
    @Column(name = "MANUAL03", length = 1000)
    private String manual03;
    @Column(name = "MANUAL04", length = 1000)
    private String manual04;
    @Column(name = "MANUAL05", length = 1000)
    private String manual05;
    @Column(name = "MANUAL06", length = 1000)
    private String manual06;
    @Column(name = "MANUAL07", length = 1000)
    private String manual07;
    @Column(name = "MANUAL08", length = 1000)
    private String manual08;
    @Column(name = "MANUAL09", length = 1000)
    private String manual09;
    @Column(name = "MANUAL10", length = 1000)
    private String manual10;
    @Column(name = "MANUAL11", length = 1000)
    private String manual11;
    @Column(name = "MANUAL12", length = 1000)
    private String manual12;
    @Column(name = "MANUAL13", length = 1000)
    private String manual13;
    @Column(name = "MANUAL14", length = 1000)
    private String manual14;
    @Column(name = "MANUAL15", length = 1000)
    private String manual15;
    @Column(name = "MANUAL16", length = 1000)
    private String manual16;
    @Column(name = "MANUAL17", length = 1000)
    private String manual17;
    @Column(name = "MANUAL18", length = 1000)
    private String manual18;
    @Column(name = "MANUAL19", length = 1000)
    private String manual19;
    @Column(name = "MANUAL20", length = 1000)
    private String manual20;

    // 리뷰 연결
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    // 재료 연결
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecipeIngredient> ingredientsList = new ArrayList<>();
}