package com.ibm.sri.tech.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table("products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {

    @Id
    private Long id;

    @Column("product_code")
    private String productCode;

    private String name;

    private String description;

    private BigDecimal price;

    @Column("stock_quantity")
    private Integer stockQuantity;

    @CreatedDate
    @Column("created_at")
    private LocalDateTime createdAt;
}
