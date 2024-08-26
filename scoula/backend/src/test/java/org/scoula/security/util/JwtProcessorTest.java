package org.scoula.security.util;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class, SecurityConfig.class})
@Log4j
class JwtProcessorTest {
    @Autowired
    JwtProcessor jwtProcessor;

    @Test
    void generateToken() {
        String username = "user0";
        String token = jwtProcessor.generateToken(username);
        log.info(token);
        assertNotNull(token);
    }

    @Test
    void getUsername() {
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMCIsImlhdCI6MTcyNDIwNjk5OSwiZXhwIjoxNzI0MjA3Mjk5fQ.FGqOk1COCAXjDLdse8L_2wa6KGaKxGYbJVp92svC-WeB74yhjXxaxtLvuCeoHytCe-7AhCcI4MtoiQIUn65U6w";
        String username = jwtProcessor.getUsername(token);
        log.info(username);
        assertNotNull(username);
    }

    @Test
    void validateToken() {
        // 5분 경과 후 테스트
        String token =
                "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMCIsImlhdCI6MTcyNDIwNjk5OSwiZXhwIjoxNzI0MjA3Mjk5fQ.FGqOk1COCAXjDLdse8L_2wa6KGaKxGYbJVp92svC-WeB74yhjXxaxtLvuCeoHytCe-7AhCcI4MtoiQIUn65U6w";
        boolean isValid = jwtProcessor.validateToken(token); // 5분 경과 후면 예외 발생
        log.info(isValid);
        assertTrue(isValid); // 5분전이면 true
    }
}