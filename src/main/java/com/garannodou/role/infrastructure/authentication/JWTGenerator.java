package com.garannodou.role.infrastructure.authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.UUID;

// TODO: Test whole class Future Mañel, Don't fuck me men
@Service
public class JWTGenerator {
    private String url;

    public JWTGenerator(@Value("${app.backend.url}") String url) {
        this.url = url;
    }

    public String generateTokenForUser(UUID userid) {
        LocalDateTime expirationDate = LocalDateTime.now().plusDays(7);
        Date expirationDateUTC = Date.from(expirationDate.toInstant(ZoneOffset.UTC));

        // TODO: Create Secret Key Repository
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        // TODO: Save secret
        String secretString = Encoders.BASE64.encode(key.getEncoded());

        String jwt = Jwts.builder().setIssuer(url)
                .setSubject(userid.toString())
                .setExpiration(expirationDateUTC)
                .claim("scope", "user")
                .signWith(key)
                .compact();

        return jwt;
    }
}
