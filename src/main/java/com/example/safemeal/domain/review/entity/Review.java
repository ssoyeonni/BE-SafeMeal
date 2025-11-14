package com.example.safemeal.domain.review.entity;

import com.example.safemeal.domain.recipe.entity.Recipe;
import com.example.safemeal.global.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "REVIEW")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TBLKEY", nullable = false)
    private Long tblKey;

//    @Column(name = "USER_NAME", length = 50, nullable = false)
//    private String userName;

    @Column(name = "TEXT", length = 1000, nullable = false)
    private String text;

    @Column(name = "DATE", length = 17, nullable = false)
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RECIPE_ID")
    private Recipe recipe;
}