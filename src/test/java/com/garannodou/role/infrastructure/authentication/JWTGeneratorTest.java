package com.garannodou.role.infrastructure.authentication;

import com.garannodou.role.infrastructure.authentication.JWTGenerator.TokenGenerationParams;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.util.UUID;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.setRemoveAssertJRelatedElementsFromStackTrace;

class JWTGeneratorTest {

    public static final UUID USER_ID = UUID.fromString("8766baca-1528-47de-a67e-22cabb9390eb");

    @Test
    public void shouldGenerateJWTForUser() {
        // Given
        JWTGenerator generator = new JWTGenerator();
        SecretKey key = Keys.secretKeyFor(HS256);

        // When
        String token = generator.generateTokenForUser(generateTokenParams(key));

        // Then
        Claims claims = decodeJWT(key, token);
        assertThat(claims.getIssuer()).isEqualTo("localhost");
        assertThat(UUID.fromString(claims.getSubject())).isEqualTo(USER_ID);
        assertThat(claims.get("scope")).isEqualTo("user");
    }

    @Test
    public void shouldFailIfTokenIsSignedWithDifferentKey() {
        // Given
        JWTGenerator generator = new JWTGenerator();
        SecretKey secretKeyA = Keys.secretKeyFor(HS256);
        SecretKey anotherSecretKey = Keys.secretKeyFor(HS256);

        // When
        String token = generator.generateTokenForUser(generateTokenParams(secretKeyA));
        // Then
        Assertions.assertThrows(SignatureException.class,
                () -> decodeJWT(anotherSecretKey, token));
    }

    private TokenGenerationParams generateTokenParams(SecretKey secretKeyA) {
        return new TokenGenerationParams(USER_ID,
                secretKeyA,
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