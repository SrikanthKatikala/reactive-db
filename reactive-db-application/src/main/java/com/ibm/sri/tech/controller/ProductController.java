package com.ibm.sri.tech.controller;

import com.ibm.sri.tech.entity.Product;
import com.ibm.sri.tech.model.dto.Session;
import com.ibm.sri.tech.model.request.ProductReq;
import com.ibm.sri.tech.service.impl.ProductServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/v1")
public class ProductController {

    private final ProductServiceImpl productService;

    @PostMapping("/get-all-products")
    public Flux<Product> getAllProducts(@RequestBody ProductReq productReq) {
        log.info("ProductController.getAllProducts() : {}", productReq);
        return productService.getAllProducts();
    }

    @PostMapping("/create/product")
    public Mono<Product> createProduct(@RequestBody Product productReq) {
        return productService.createProduct(productReq);
    }

    @PostMapping("/get-prod-by-id")
    public Mono<Product> getProductById(@RequestBody ProductReq productReq) {
        return productService.getProductById(productReq.getProductId());
    }


    @PostMapping("/create-session")
    public Mono<Session> getProductById(@RequestBody Session sessionReq) {
        return productService.createSession(sessionReq);
    }
}
