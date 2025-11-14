package com.example.safemeal.global.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @Column(name = "ADDDATE", length = 17)
    private String addDate; // yyyyMMddHHmmssfff

    @Column(name = "MODIFYDATE", length = 17)
    private String modifyDate;

    @Column(name = "COMKEY", length = 50)
    private String comKey;
}
