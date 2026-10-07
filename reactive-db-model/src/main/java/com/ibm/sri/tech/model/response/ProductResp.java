package com.ibm.sri.tech.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResp {

    private Long id;

    private String productCode;

    private String name;

    private String description;

    private BigDecimal price;

    private Integer stockQuantity;

    private LocalDateTime createdAt;
}
