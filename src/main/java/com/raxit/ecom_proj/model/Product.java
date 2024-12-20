package com.raxit.ecom_proj.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date releaseDate;

    private String name;
    private String description;
    private String brand;
    private BigDecimal price; 
    private String category;
    private boolean productAvailable;
    private int stockQuantity;

    private String imageName;
    private String imageType;
    @Lob
    private byte[] image;
}