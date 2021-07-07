package com.garannodou.role.infrastructure.authentication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
class SecretKeyRepositoryConfig {

    private final String secretKeyEncodedInBase64;

    SecretKeyRepositoryConfig(@Value("JWT_SECRET_KEY") String secretKeyEncodedInBase64) {
        this.secretKeyEncodedInBase64 = secretKeyEncodedInBase64;
    }

    public String getSecretKeyEncodedInBase64() {
        return secretKeyEncodedInBase64;
    }
}
