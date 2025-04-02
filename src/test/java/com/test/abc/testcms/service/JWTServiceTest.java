package com.test.abc.testcms.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

@ExtendWith(MockitoExtension.class)
class JWTServiceTest {

    private JWTService jwtService;

    @BeforeEach
    void setUp() {
        jwtService = new JWTService();
        AtomicReference<String> secretKey = new AtomicReference<>("secretKey");
        IntStream.range(0, 10).forEach(i -> {
            secretKey.set(secretKey.get() + UUID.randomUUID().toString().replace("-", ""));
        });
        ReflectionTestUtils.setField(jwtService, "secretKey", secretKey.get());
        ReflectionTestUtils.setField(jwtService, "jwtExpiration", 3600);
    }

    @Test
    void generateToken() {
         Map<String, Object> extraClaims = new HashMap<>();
         UserDetails userDetails = new User("username", "password", List.of());
         String token = jwtService.generateToken(extraClaims, userDetails);
         Assertions.assertNotNull(token);
    }

    @Test
    void extractUsername() {
        UserDetails userDetails = new User("username", "password", List.of());
        String token = jwtService.generateToken(userDetails);
        String username = jwtService.extractUsername(token);
        Assertions.assertNotNull(username);
        Assertions.assertEquals("username", username);
    }

}