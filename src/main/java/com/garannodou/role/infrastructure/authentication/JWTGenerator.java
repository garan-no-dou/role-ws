package com.garannodou.role.infrastructure.authentication;

import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.UUID;

@Service
public class JWTGenerator {

    private final SecretKeyRepository secretKeyRepository;

    public JWTGenerator(SecretKeyRepository secretKeyRepository) {
        this.secretKeyRepository = secretKeyRepository;
    }

    public String generateTokenForUser(TokenGenerationParams params) {
        LocalDateTime expirationDate = LocalDateTime.now().plusDays(7); // FIXME: Don't use "now()"
        Date expirationDateUTC = Date.from(expirationDate.toInstant(ZoneOffset.UTC));

        String jwt = Jwts.builder()
                .setIssuer(params.url)
                .setSubject(params.userId.toString())
                .setExpiration(expirationDateUTC)
                .claim("scope", params.scope)
                .signWith(secretKeyRepository.getSecretKey())
                .compact();

        return jwt;
    }

    @Data
    @AllArgsConstructor
    static class TokenGenerationParams {
        private UUID userId;
        private String url;
        private String scope;
    }
}
