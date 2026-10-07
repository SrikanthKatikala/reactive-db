package com.ibm.sri.tech.cache;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
@AllArgsConstructor
public class RedisCacheService {

    private final ReactiveRedisTemplate reactiveRedisTemplate;

    public <T> Mono<T> getFromCache(String key, Class<T> clazz) {
        return reactiveRedisTemplate.opsForValue().get(key).cast(clazz);
    }

    public <T> Mono<Boolean> putInCache(String key, T value, Duration ttl) {
        return reactiveRedisTemplate.opsForValue().setIfAbsent(key, value, ttl);
    }

    public <T> Mono<Boolean> putInCache(String key, T value) {
        return reactiveRedisTemplate.opsForValue().setIfAbsent(key, value, Duration.ofMinutes(10));
    }
}
