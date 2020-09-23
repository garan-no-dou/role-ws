package com.garannodou.role.controller;

import com.garannodou.role.controller.GoogleAuthRequest.GoogleAuth;
import com.garannodou.role.controller.GoogleAuthRequest.GoogleBasicProfile;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoogleAuthRequestTest {

    /*
    GoogleBasicProfile field tests
     */

    @Test
    public void testNameLengthIsInvalidWhenIsTooShort() {
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleBasicProfile googleBasicProfile = googleAuthRequest.getGoogleBasicProfile();
        googleBasicProfile.setName("u");
    }

    @Test
    public void testNameLengthIsInvalidWhenIsTooLong() {
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleBasicProfile googleBasicProfile = googleAuthRequest.getGoogleBasicProfile();
        googleBasicProfile.setName("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
    }

    @Test
    public void testGivenNameLengthIsInvalidWhenIsTooShort() {
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleBasicProfile googleBasicProfile = googleAuthRequest.getGoogleBasicProfile();
        googleBasicProfile.setGivenName("u");
    }

    @Test
    public void testGivenNameLengthIsInvalidWhenIsTooLong() {
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleBasicProfile googleBasicProfile = googleAuthRequest.getGoogleBasicProfile();
        googleBasicProfile.setGivenName("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
    }

    @Test
    public void testFamilyNameLengthIsInvalidWhenIsTooShort() {
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleBasicProfile googleBasicProfile = googleAuthRequest.getGoogleBasicProfile();
        googleBasicProfile.setFamilyName("u");
    }

    @Test
    public void testFamilyNameLengthIsInvalidWhenIsTooLong() {
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleBasicProfile googleBasicProfile = googleAuthRequest.getGoogleBasicProfile();
        googleBasicProfile.setFamilyName("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
    }

    @Test
    public void testImageUrlLengthIsInvalidWhenIsTooShort() {
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleBasicProfile googleBasicProfile = googleAuthRequest.getGoogleBasicProfile();
        googleBasicProfile.setEmail("u");
    }

    @Test
    public void testImageUrlLengthIsInvalidWhenIsTooLong() {
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleBasicProfile googleBasicProfile = googleAuthRequest.getGoogleBasicProfile();
        googleBasicProfile.setEmail("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
    }

    @Test
    public void testEmailLengthIsInvalidWhenIsTooShort() {
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleBasicProfile googleBasicProfile = googleAuthRequest.getGoogleBasicProfile();
        googleBasicProfile.setEmail("u");
    }

    @Test
    public void testEmailLengthIsInvalidWhenIsTooLong() {
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleBasicProfile googleBasicProfile = googleAuthRequest.getGoogleBasicProfile();
        googleBasicProfile.setEmail("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
    }

    /*
    GoogleAuth field tests
     */
    public void testAccessTokenLengthIsInvalidWhenIsTooShort() {
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleAuth googleAuth = googleAuthRequest.getGoogleAuth();
        googleAuth.setAccessToken("u");
    }

    public void testAccessTokenLengthIsInvalidWhenIsTooLong() {
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleAuth googleAuth = googleAuthRequest.getGoogleAuth();
        googleAuth.setAccessToken("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
    }

    public void testIdTokenLengthIsvalidWhenIsTooShort() {
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleAuth googleAuth = googleAuthRequest.getGoogleAuth();
        googleAuth.setIdToken("u");
    }

    public void testIdTokenLengthIsInvalidWhenIsTooLong() {
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleAuth googleAuth = googleAuthRequest.getGoogleAuth();
        googleAuth.setIdToken("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
    }

    public void testScopeLengthIsInvalidWhenIsTooShort() {
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleAuth googleAuth = googleAuthRequest.getGoogleAuth();
        googleAuth.setScope("u");
    }

    public void testScopeLengthIsInvalidWhenIsTooLong() {
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleAuth googleAuth = googleAuthRequest.getGoogleAuth();
        googleAuth.setScope("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
    }

    public void testExpiresInLengthIsInvalidWhenIsTooShort() {
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleAuth googleAuth = googleAuthRequest.getGoogleAuth();
        googleAuth.setExpiresIn("u");
    }

    public void testExpiresInLengthIsInvalidWhenIsTooLong() {
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleAuth googleAuth = googleAuthRequest.getGoogleAuth();
        googleAuth.setExpiresIn("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
    }

    public void testFirstIssuedAtLengthIsvalidWhenIsTooShort() {
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleAuth googleAuth = googleAuthRequest.getGoogleAuth();
        googleAuth.setFirstIssuedAt("u");
    }

    public void testFirstIssuedAtLengthIsInvalidWhenIsTooLong() {
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleAuth googleAuth = googleAuthRequest.getGoogleAuth();
        googleAuth.setFirstIssuedAt("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
    }

    public void testExpiresAtLengthIsInvalidWhenIsTooShort() {
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleAuth googleAuth = googleAuthRequest.getGoogleAuth();
        googleAuth.setExpiresAt("u");
    }

    public void testExpiresAtLengthIsInvalidWhenIsTooLong() {
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleAuth googleAuth = googleAuthRequest.getGoogleAuth();
        googleAuth.setExpiresAt("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
    }

    private GoogleAuthRequest createValidGoogleAuthRequest() {
        GoogleAuthRequest googleAuthRequest = new GoogleAuthRequest();

        GoogleBasicProfile basicProfile = googleAuthRequest.getGoogleBasicProfile();
/*
        basicProfile.setName("Sanguinius");
        basicProfile.setGivenName("Blood Angels Primarch");
        basicProfile.setFamilyName("Blood Angels");
        basicProfile.setImageUrl("https://www.test.com/image.png");
        basicProfile.setEmail("test.test@gmail.com");
*/

        GoogleAuth googleAuth = googleAuthRequest.getGoogleAuth();
/*
        googleAuth.setAccessToken("someAccessToken");
        googleAuth.setIdToken("someIdToken");
        googleAuth.setScope("scope");
        googleAuth.setExpiresIn("1000");
        googleAuth.setFirstIssuedAt("firstIssuedAt");
        googleAuth.setExpiresAt("expiresAt");
*/

        return googleAuthRequest;
    }
}