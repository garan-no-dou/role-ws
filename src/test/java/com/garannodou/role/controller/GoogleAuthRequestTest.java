package com.garannodou.role.controller;

import com.garannodou.role.controller.GoogleAuthRequest.GoogleAuth;
import com.garannodou.role.controller.GoogleAuthRequest.GoogleBasicProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Validation;
import javax.validation.Validator;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoogleAuthRequestTest {

    /*
    GoogleBasicProfile field tests
     */
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    private GoogleAuthRequest googleAuthRequest;
    private GoogleBasicProfile googleBasicProfile;
    private GoogleAuth googleAuth;

    @BeforeEach
    void setUp() {
        googleAuthRequest = createValidGoogleAuthRequest();
        googleBasicProfile = googleAuthRequest.getGoogleBasicProfile();
        googleAuth = googleAuthRequest.getGoogleAuth();
    }

    @Test
    public void testNameLengthIsInvalidWhenIsTooShort() {
        //Given

        //When
        googleBasicProfile.setName("u");

        //Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleBasicProfile>> constraintViolations =
                new ArrayList<>(validator.validate(googleBasicProfile));

        checkThatOnlyThisPropertyFails(constraintViolations.size(), constraintViolations.get(0).getPropertyPath(), "name");
    }

    @Test
    public void testNameLengthIsInvalidWhenIsTooLong() {
        //Given

        //When
        googleBasicProfile.setName("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");

        //Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleBasicProfile>> constraintViolations =
                new ArrayList<>(validator.validate(googleBasicProfile));

        checkThatOnlyThisPropertyFails(constraintViolations.size(), constraintViolations.get(0).getPropertyPath(), "name");
    }

    @Test
    public void testGivenNameLengthIsInvalidWhenIsTooShort() {
        //Given

        //When
        googleBasicProfile.setGivenName("u");

        //Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleBasicProfile>> constraintViolations =
                new ArrayList<>(validator.validate(googleBasicProfile));

        checkThatOnlyThisPropertyFails(constraintViolations.size(), constraintViolations.get(0).getPropertyPath(), "givenName");
    }

    @Test
    public void testGivenNameLengthIsInvalidWhenIsTooLong() {
        //Given

        //When
        googleBasicProfile.setGivenName("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");

        //Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleBasicProfile>> constraintViolations =
                new ArrayList<>(validator.validate(googleBasicProfile));

        checkThatOnlyThisPropertyFails(constraintViolations.size(), constraintViolations.get(0).getPropertyPath(), "givenName");
    }

    @Test
    public void testFamilyNameLengthIsInvalidWhenIsTooShort() {
        //Given

        //When
        googleBasicProfile.setFamilyName("u");

        //Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleBasicProfile>> constraintViolations =
                new ArrayList<>(validator.validate(googleBasicProfile));

        checkThatOnlyThisPropertyFails(constraintViolations.size(), constraintViolations.get(0).getPropertyPath(), "familyName");
    }

    @Test
    public void testFamilyNameLengthIsInvalidWhenIsTooLong() {
        //Given

        //When
        googleBasicProfile.setFamilyName("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");

        //Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleBasicProfile>> constraintViolations =
                new ArrayList<>(validator.validate(googleBasicProfile));

        checkThatOnlyThisPropertyFails(constraintViolations.size(), constraintViolations.get(0).getPropertyPath(), "familyName");
    }

    /*
    GoogleAuth field tests
     */
    @Test
    public void testAccessTokenLengthIsInvalidWhenIsTooShort() {
        // Given

        // When
        googleAuth.setAccessToken("u");

        // Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleAuth>> constraintViolations =
                new ArrayList<>(validator.validate(googleAuth));

        checkThatOnlyThisPropertyFails(constraintViolations.size(), constraintViolations.get(0).getPropertyPath(), "accessToken");
    }

    @Test
    public void testAccessTokenLengthIsInvalidWhenIsTooLong() {
        // Given

        // When
        googleAuth.setAccessToken("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");

        // Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleAuth>> constraintViolations =
                new ArrayList<>(validator.validate(googleAuth));

        checkThatOnlyThisPropertyFails(constraintViolations.size(), constraintViolations.get(0).getPropertyPath(), "accessToken");
    }

    @Test
    public void testIdTokenLengthIsvalidWhenIsTooShort() {
        // Given

        // When
        googleAuth.setIdToken("u");

        // Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleAuth>> constraintViolations =
                new ArrayList<>(validator.validate(googleAuth));

        checkThatOnlyThisPropertyFails(constraintViolations.size(), constraintViolations.get(0).getPropertyPath(), "idToken");
    }

    @Test
    public void testIdTokenLengthIsInvalidWhenIsTooLong() {
        // Given

        //When
        googleAuth.setIdToken("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");

        // Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleAuth>> constraintViolations =
                new ArrayList<>(validator.validate(googleAuth));

        checkThatOnlyThisPropertyFails(constraintViolations.size(), constraintViolations.get(0).getPropertyPath(), "idToken");
    }

    @Test
    public void testScopeLengthIsInvalidWhenIsTooShort() {
        // Given

        //When
        googleAuth.setScope("");

        // Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleAuth>> constraintViolations =
                new ArrayList<>(validator.validate(googleAuth));

        checkThatOnlyThisPropertyFails(constraintViolations.size(), constraintViolations.get(0).getPropertyPath(), "scope");
    }

    @Test
    public void testScopeLengthIsInvalidWhenIsTooLong() {
        // Given

        //When
        googleAuth.setScope("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");

        // Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleAuth>> constraintViolations =
                new ArrayList<>(validator.validate(googleAuth));

        checkThatOnlyThisPropertyFails(constraintViolations.size(), constraintViolations.get(0).getPropertyPath(), "scope");
    }

    @Test
    public void testExpiresInLengthIsInvalidWhenIsTooShort() {
        // Given

        // When
        googleAuth.setExpiresIn("");

        //Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleAuth>> constraintViolations =
                new ArrayList<>(validator.validate(googleAuth));

        checkThatOnlyThisPropertyFails(constraintViolations.size(), constraintViolations.get(0).getPropertyPath(), "expiresIn");
    }

    @Test
    public void testExpiresInLengthIsInvalidWhenIsTooLong() {
        // Given

        //When
        googleAuth.setExpiresIn("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");

        // Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleAuth>> constraintViolations =
                new ArrayList<>(validator.validate(googleAuth));

        checkThatOnlyThisPropertyFails(constraintViolations.size(), constraintViolations.get(0).getPropertyPath(), "expiresIn");
    }

    @Test
    public void testFirstIssuedAtLengthIsvalidWhenIsTooShort() {
        // Given

        //Where
        googleAuth.setFirstIssuedAt("");

        // Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleAuth>> constraintViolations =
                new ArrayList<>(validator.validate(googleAuth));

        checkThatOnlyThisPropertyFails(constraintViolations.size(), constraintViolations.get(0).getPropertyPath(), "firstIssuedAt");
    }

    @Test
    public void testFirstIssuedAtLengthIsInvalidWhenIsTooLong() {
        // Given

        // When
        googleAuth.setFirstIssuedAt("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");

        // Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleAuth>> constraintViolations =
                new ArrayList<>(validator.validate(googleAuth));

        checkThatOnlyThisPropertyFails(constraintViolations.size(), constraintViolations.get(0).getPropertyPath(), "firstIssuedAt");
    }

    @Test
    public void testExpiresAtLengthIsInvalidWhenIsTooShort() {
        // Given

        // When
        googleAuth.setExpiresAt("");

        // Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleAuth>> constraintViolations =
                new ArrayList<>(validator.validate(googleAuth));

        checkThatOnlyThisPropertyFails(constraintViolations.size(), constraintViolations.get(0).getPropertyPath(), "expiresAt");
    }

    @Test
    public void testExpiresAtLengthIsInvalidWhenIsTooLong() {
        // Given

        //When
        googleAuth.setExpiresAt("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");

        // Then
        List<ConstraintViolation<GoogleAuthRequest.GoogleAuth>> constraintViolations =
                new ArrayList<>(validator.validate(googleAuth));

        checkThatOnlyThisPropertyFails(constraintViolations.size(), constraintViolations.get(0).getPropertyPath(), "expiresAt");
    }

    private static void checkThatOnlyThisPropertyFails(int size, Path propertyPath, String name) {
        assertThat(size, is(1));

        String propertyThatFais = propertyPath.toString();

        assertThat(propertyThatFais, is(name));
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