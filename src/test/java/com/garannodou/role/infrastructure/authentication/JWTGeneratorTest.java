package com.garannodou.role.infrastructure.authentication;

import com.garannodou.role.infrastructure.authentication.JWTGenerator.TokenGenerationParams;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.util.UUID;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class JWTGeneratorTest {

    public static final UUID USER_ID = UUID.fromString("8766baca-1528-47de-a67e-22cabb9390eb");
    private SecretKeyRepository secretKeyRepository;


    @BeforeEach
    void setUp() {
        secretKeyRepository = mock(SecretKeyRepository.class);
    }

    @Test
    public void shouldGenerateJWTForUser() {
        // Given
        SecretKey key = Keys.secretKeyFor(HS256);
        when(secretKeyRepository.getSecretKey()).thenReturn(key);
        JWTGenerator generator = new JWTGenerator(secretKeyRepository);

        // When
        String token = generator.generateTokenForUser(generateTokenParams());

        // Then
        Claims claims = decodeJWT(key, token);
        assertThat(claims.getIssuer()).isEqualTo("localhost");
        assertThat(UUID.fromString(claims.getSubject())).isEqualTo(USER_ID);
        assertThat(claims.get("scope")).isEqualTo("user");
    }

    @Test
    public void shouldFailWhenDecodingIfTokenIsSignedWithDifferentKey() {
        // Given
        SecretKey secretKeyA = Keys.secretKeyFor(HS256);
        SecretKey anotherSecretKey = Keys.secretKeyFor(HS256);
        when(secretKeyRepository.getSecretKey()).thenReturn(secretKeyA);
        JWTGenerator generator = new JWTGenerator(secretKeyRepository);

        // When
        String token = generator.generateTokenForUser(generateTokenParams());

        // Then
        Assertions.assertThrows(SignatureException.class,
                () -> decodeJWT(anotherSecretKey, token));
    }

    private TokenGenerationParams generateTokenParams() {
        return new TokenGenerationParams(USER_ID,
                "localhost",
                "user");
    }

    private Claims decodeJWT(SecretKey key, String token) {
        Jws<Claims> jws = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
        return jws.getBody();
    }

}