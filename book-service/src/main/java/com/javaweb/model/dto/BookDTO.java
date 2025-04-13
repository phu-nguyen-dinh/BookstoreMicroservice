package com.javaweb.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {
    private Long id;
    
    private String title;
    private Long authorID;
    private Integer price;
    private Integer quantity;
} 