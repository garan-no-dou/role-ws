package com.garannodou.role.controller;

import com.garannodou.role.controller.GoogleAuthRequest.GoogleAuth;
import com.garannodou.role.controller.GoogleAuthRequest.GoogleBasicProfile;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoogleAuthRequestTest {

    /*
    GoogleBasicProfile field tests
     */
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void testNameLengthIsInvalidWhenIsTooShort() {
        //Given
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleBasicProfile googleBasicProfile = googleAuthRequest.getGoogleBasicProfile();
        //When
        googleBasicProfile.setName("u");

        //Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleBasicProfile>> constraintViolations =
                new ArrayList<>(validator.validate(googleBasicProfile));

        assertThat(constraintViolations.size(), is(1));

        String propertyThatFais = constraintViolations.get(0).getPropertyPath().toString();

        assertThat(propertyThatFais, is("name"));
    }

    @Test
    public void testNameLengthIsInvalidWhenIsTooLong() {
        //Given
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleBasicProfile googleBasicProfile = googleAuthRequest.getGoogleBasicProfile();

        //When
        googleBasicProfile.setName("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");

        //Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleBasicProfile>> constraintViolations =
                new ArrayList<>(validator.validate(googleBasicProfile));

        assertThat(constraintViolations.size(), is(1));

        String propertyThatFails = constraintViolations.get(0).getPropertyPath().toString();

        assertThat(propertyThatFails, is("name"));
    }

    @Test
    public void testGivenNameLengthIsInvalidWhenIsTooShort() {
        //Given
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleBasicProfile googleBasicProfile = googleAuthRequest.getGoogleBasicProfile();

        //When
        googleBasicProfile.setGivenName("u");

        //Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleBasicProfile>>constraintViolations=
                new ArrayList<>(validator.validate(googleBasicProfile));

        assertThat(constraintViolations.size(),is(1));

        String propertyThatFails = constraintViolations.get(0).getPropertyPath().toString();
        assertThat(propertyThatFails,is("givenName"));
    }

    @Test
    public void testGivenNameLengthIsInvalidWhenIsTooLong() {
        //Given
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleBasicProfile googleBasicProfile = googleAuthRequest.getGoogleBasicProfile();

        //When
        googleBasicProfile.setGivenName("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");

        //Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleBasicProfile>> constraintViolations =
                new ArrayList<>(validator.validate(googleBasicProfile));

        assertThat(constraintViolations.size(), is(1));

        String propertyThatFails = constraintViolations.get(0).getPropertyPath().toString();

        assertThat(propertyThatFails, is("givenName"));
    }

    @Test
    public void testFamilyNameLengthIsInvalidWhenIsTooShort() {
        //Given
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleBasicProfile googleBasicProfile = googleAuthRequest.getGoogleBasicProfile();

        //When
        googleBasicProfile.setFamilyName("u");

        //Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleBasicProfile>> constraintViolations =
                new ArrayList<>(validator.validate(googleBasicProfile));

        assertThat(constraintViolations.size(), is(1));

        String propertyThatFails = constraintViolations.get(0).getPropertyPath().toString();

        assertThat(propertyThatFails, is("familyName"));
    }

    @Test
    public void testFamilyNameLengthIsInvalidWhenIsTooLong() {
        //Given
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleBasicProfile googleBasicProfile = googleAuthRequest.getGoogleBasicProfile();

        //When
        googleBasicProfile.setFamilyName("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");

        //Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleBasicProfile>> constraintViolations =
                new ArrayList<>(validator.validate(googleBasicProfile));

        assertThat(constraintViolations.size(), is(1));

        String propertyThatFails = constraintViolations.get(0).getPropertyPath().toString();

        assertThat(propertyThatFails, is("familyName"));
    }

    /*
    GoogleAuth field tests
     */
    @Test
    public void testAccessTokenLengthIsInvalidWhenIsTooShort() {
        // Given
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleAuth googleAuth = googleAuthRequest.getGoogleAuth();

        // When
        googleAuth.setAccessToken("u");

        // Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleAuth>> constraintViolations =
                new ArrayList<>(validator.validate(googleAuth));

        assertThat(constraintViolations.size(), is(1));

        String propertyThatFails = constraintViolations.get(0).getPropertyPath().toString();

        assertThat(propertyThatFails, is("accessToken"));
    }

    @Test
    public void testAccessTokenLengthIsInvalidWhenIsTooLong() {
        // Given
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleAuth googleAuth = googleAuthRequest.getGoogleAuth();

        // When
        googleAuth.setAccessToken("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");

        // Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleAuth>> constraintViolations =
                new ArrayList<>(validator.validate(googleAuth));

        assertThat(constraintViolations.size(), is(1));

        String propertyThatFails = constraintViolations.get(0).getPropertyPath().toString();

        assertThat(propertyThatFails, is("accessToken"));
    }

    @Test
    public void testIdTokenLengthIsvalidWhenIsTooShort() {
        // Given
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleAuth googleAuth = googleAuthRequest.getGoogleAuth();

        // When
        googleAuth.setIdToken("u");

        // Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleAuth>> constraintViolations =
                new ArrayList<>(validator.validate(googleAuth));

        assertThat(constraintViolations.size(), is(1));

        String propertyThatFails = constraintViolations.get(0).getPropertyPath().toString();

        assertThat(propertyThatFails, is("idToken"));
    }

    @Test
    public void testIdTokenLengthIsInvalidWhenIsTooLong() {
        // Given
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleAuth googleAuth = googleAuthRequest.getGoogleAuth();

        //When
        googleAuth.setIdToken("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");

        // Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleAuth>> constraintViolations =
                new ArrayList<>(validator.validate(googleAuth));

        assertThat(constraintViolations.size(), is(1));

        String propertyThatFails = constraintViolations.get(0).getPropertyPath().toString();

        assertThat(propertyThatFails, is("idToken"));
    }

    @Test
    public void testScopeLengthIsInvalidWhenIsTooShort() {
        // Given
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleAuth googleAuth = googleAuthRequest.getGoogleAuth();

        //When
        googleAuth.setScope("");

        // Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleAuth>> constraintViolations =
                new ArrayList<>(validator.validate(googleAuth));

        assertThat(constraintViolations.size(), is(1));

        String propertyThatFails = constraintViolations.get(0).getPropertyPath().toString();

        assertThat(propertyThatFails, is("scope"));
    }

    @Test
    public void testScopeLengthIsInvalidWhenIsTooLong() {
        // Given
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleAuth googleAuth = googleAuthRequest.getGoogleAuth();

        //When
        googleAuth.setScope("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");

        // Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleAuth>> constraintViolations =
                new ArrayList<>(validator.validate(googleAuth));

        assertThat(constraintViolations.size(), is(1));

        String propertyThatFails = constraintViolations.get(0).getPropertyPath().toString();

        assertThat(propertyThatFails, is("scope"));
    }

    @Test
    public void testExpiresInLengthIsInvalidWhenIsTooShort() {
        // Given
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleAuth googleAuth = googleAuthRequest.getGoogleAuth();

        // When
        googleAuth.setExpiresIn("");

        //Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleAuth>> constraintViolations =
                new ArrayList<>(validator.validate(googleAuth));

        assertThat(constraintViolations.size(), is(1));

        String propertyThatFails = constraintViolations.get(0).getPropertyPath().toString();

        assertThat(propertyThatFails, is("expiresIn"));
    }

    @Test
    public void testExpiresInLengthIsInvalidWhenIsTooLong() {
        // Given
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleAuth googleAuth = googleAuthRequest.getGoogleAuth();

        //When
        googleAuth.setExpiresIn("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");

        // Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleAuth>> constraintViolations =
                new ArrayList<>(validator.validate(googleAuth));

        assertThat(constraintViolations.size(), is(1));

        String propertyThatFails = constraintViolations.get(0).getPropertyPath().toString();

        assertThat(propertyThatFails, is("expiresIn"));
    }

    @Test
    public void testFirstIssuedAtLengthIsvalidWhenIsTooShort() {
        // Given
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleAuth googleAuth = googleAuthRequest.getGoogleAuth();

        //Where
        googleAuth.setFirstIssuedAt("");

        // Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleAuth>> constraintViolations =
                new ArrayList<>(validator.validate(googleAuth));

        assertThat(constraintViolations.size(), is(1));

        String propertyThatFails = constraintViolations.get(0).getPropertyPath().toString();

        assertThat(propertyThatFails, is("firstIssuedAt"));
    }

    @Test
    public void testFirstIssuedAtLengthIsInvalidWhenIsTooLong() {
        // Given
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleAuth googleAuth = googleAuthRequest.getGoogleAuth();

        // When
        googleAuth.setFirstIssuedAt("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");

        // Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleAuth>> constraintViolations =
                new ArrayList<>(validator.validate(googleAuth));

        assertThat(constraintViolations.size(), is(1));

        String propertyThatFails = constraintViolations.get(0).getPropertyPath().toString();

        assertThat(propertyThatFails, is("firstIssuedAt"));
    }

    @Test
    public void testExpiresAtLengthIsInvalidWhenIsTooShort() {
        // Given
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleAuth googleAuth = googleAuthRequest.getGoogleAuth();

        // When
        googleAuth.setExpiresAt("");

        // Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleAuth>> constraintViolations =
                new ArrayList<>(validator.validate(googleAuth));

        assertThat(constraintViolations.size(), is(1));

        String propertyThatFails = constraintViolations.get(0).getPropertyPath().toString();

        assertThat(propertyThatFails, is("expiresAt"));
    }

    @Test
    public void testExpiresAtLengthIsInvalidWhenIsTooLong() {
        // Given
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        GoogleAuth googleAuth = googleAuthRequest.getGoogleAuth();

        //When
        googleAuth.setExpiresAt("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");

        // Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleAuth>> constraintViolations =
                new ArrayList<>(validator.validate(googleAuth));

        assertThat(constraintViolations.size(), is(1));

        String propertyThatFails = constraintViolations.get(0).getPropertyPath().toString();

        assertThat(propertyThatFails, is("expiresAt"));
    }

    private GoogleAuthRequest createValidGoogleAuthRequest() {
        GoogleAuthRequest googleAuthRequest = new GoogleAuthRequest();

        GoogleBasicProfile basicProfile = googleAuthRequest.getGoogleBasicProfile();
        basicProfile.setName("Sanguinius");
        basicProfile.setGivenName("Blood Angels Primarch");
        basicProfile.setFamilyName("Blood Angels");
        basicProfile.setImageUrl("https://www.test.com/image.png");
        basicProfile.setEmail("testtest@gmail.com");

        GoogleAuth googleAuth = googleAuthRequest.getGoogleAuth();
        googleAuth.setAccessToken("someAccessToken");
        googleAuth.setIdToken("someIdToken");
        googleAuth.setScope("scope");
        googleAuth.setExpiresIn("1000");
        googleAuth.setFirstIssuedAt("firstIssuedAt");
        googleAuth.setExpiresAt("expiresAt");

        return googleAuthRequest;
    }
}