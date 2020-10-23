package com.garannodou.role.infrastructure.authentication;

import org.junit.jupiter.api.Test;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;

class SecretKeyRepositoryTest {

    @Test
    public void shouldReturnSecretKeyBuiltFromBase64String() throws Exception {
        // Given
        String keyBase64Encoded = generateSecretKeyAsStringBase64();
        SecretKeyRepositoryConfig config = new SecretKeyRepositoryConfig(keyBase64Encoded);
        SecretKeyRepository repository = new SecretKeyRepository(config);

        // When
        SecretKey secretKey = repository.getSecretKey();

        // Then
        String actualKeyInBase64 = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        assertThat(actualKeyInBase64).isEqualTo(keyBase64Encoded);
    }

    // This is also useful as documentation of how to generate a new one in the future.
    private String generateSecretKeyAsStringBase64() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] encodedKey = secretKey.getEncoded();
        return Base64.getEncoder().encodeToString(encodedKey);
    }

}