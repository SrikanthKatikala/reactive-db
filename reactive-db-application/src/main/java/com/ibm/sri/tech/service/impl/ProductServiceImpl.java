package com.ibm.sri.tech.service.impl;

import com.ibm.sri.tech.cache.RedisCacheService;
import com.ibm.sri.tech.entity.Product;
import com.ibm.sri.tech.exception.ErrorEnum;
import com.ibm.sri.tech.exception.SessionException;
import com.ibm.sri.tech.model.dto.Session;
import com.ibm.sri.tech.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@AllArgsConstructor
public class ProductServiceImpl {

    private final ProductRepository productRepository;
    private final RedisCacheService redisCacheService;

    public Flux<Product> getAllProducts() {
        return getSession().flatMapIterable(resp -> productRepository.findAll().toIterable());
    }

    public Mono<Product> createProduct(Product productReq) {
        return productRepository.save(productReq).flatMap(check -> {
            log.info("Creating product {}", check);
            return Mono.just(check);
        });
    }

    public Mono<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

    public Mono<Session> createSession(Session sessionReq) {
        return redisCacheService.putInCache("session", sessionReq).flatMap(resp -> {
            log.info("Is session created {}", resp);
            return Mono.just(sessionReq);
        });
    }

    private Mono<Session> getSession() {
        return redisCacheService.getFromCache("session", Session.class)
                .flatMap(resp -> {
                    if (resp == null || resp.getSessionId() == null || resp.getUserId() == null) {
                        throw new SessionException(ErrorEnum.SESSION_NOT_FOUND, "session not found");
                    }
                    return Mono.just(resp);
                });
    }

}
