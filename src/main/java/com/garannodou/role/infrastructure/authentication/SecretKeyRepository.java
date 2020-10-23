package com.garannodou.role.infrastructure.authentication;

import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Service
class SecretKeyRepository {

    private final SecretKeyRepositoryConfig config;

    SecretKeyRepository(SecretKeyRepositoryConfig config) {
        this.config = config;
    }

    SecretKey getSecretKey() {
        String keyInBase64 = config.getSecretKeyEncodedInBase64();

        byte[] decodedKey = Base64.getDecoder().decode(keyInBase64);
        SecretKey secretKey = new SecretKeySpec(decodedKey, 0,
                decodedKey.length, "AES");

        return secretKey;
    }
}
