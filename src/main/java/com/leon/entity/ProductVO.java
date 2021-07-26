package com.leon.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductVO implements Serializable {
    private Long id;

    private String name;

    private Long count;

    private Long userId;

    private String userName;
}
