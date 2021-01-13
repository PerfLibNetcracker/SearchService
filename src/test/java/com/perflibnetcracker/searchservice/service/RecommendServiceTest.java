package com.perflibnetcracker.searchservice.service;

import com.perflibnetcracker.searchservice.exception.ServiceEmptyResultException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static java.util.Objects.isNull;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Данный тест работает только в том случае, если сервис рекомендаций имеет как минимум двух пользователей
 * И пользователи сделали хоть какой то фидбек
 */
@SpringBootTest
public class RecommendServiceTest {
    @Autowired
    private RecommendService recommendService;

    // Если тест выдаёт http error: unexpected end of JSON input - сервис рекомендаций пустой, нужен фидбек
    @Test
    public void testPopular() throws ServiceEmptyResultException {
        assertFalse(isNull(recommendService.getPopularBooks("1")));
        assertFalse(isNull(recommendService.getPopularBooks()));
    }

    @Test
    public void testRecommends() throws ServiceEmptyResultException {
        assertFalse(isNull(recommendService.getUserBooks("2")));
    }
}
