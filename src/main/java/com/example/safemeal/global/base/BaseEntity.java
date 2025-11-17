package com.example.safemeal.global.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"); // 17자리 형식

    @Column(name = "ADDDATE", length = 17)
    private String addDate; // yyyyMMddHHmmssfff

    @Column(name = "MODIFYDATE", length = 17)
    private String modifyDate;

    // INSERT 시 자동 설정
    @PrePersist
    protected void onCreate() {
        String now = LocalDateTime.now().format(FORMATTER);
        this.addDate = now;
        this.modifyDate = now;
    }

    // UPDATE 시 자동 설정
    @PreUpdate
    protected void onUpdate() {
        this.modifyDate = LocalDateTime.now().format(FORMATTER);
    }
}
