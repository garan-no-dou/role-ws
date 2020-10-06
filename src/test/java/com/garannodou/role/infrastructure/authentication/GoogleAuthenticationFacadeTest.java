package com.garannodou.role.infrastructure.authentication;

import com.garannodou.role.controller.GoogleAuthRequest;
import com.garannodou.role.domain.User;
import com.garannodou.role.service.UserCreateDTO;
import com.garannodou.role.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class GoogleAuthenticationFacadeTest {

    private UserService userServiceMock;
    private GoogleAuthenticationFacade sut;
    private JWTGenerator jwtGenerator;

    @BeforeEach
    void setUp() {
        userServiceMock = mock(UserService.class);
        jwtGenerator = new JWTGeneratorStub();
        sut = new GoogleAuthenticationFacade(userServiceMock, jwtGenerator, "localhost");
    }

    @Test
    void testAuthenticateUserIfUserIsFound() {
        // Given
        var authRequest = createValidGoogleAuthRequest();
        when(userServiceMock.findUserByEmail("test.test@gmail.com"))
                .thenReturn(Optional.of(new User("Sanguinius", "Sanguinius", "test.test@gmail.com", null)));

        // When
        String authenticationResponse = sut.authenticate(authRequest);

        // Then
        assertThat(authenticationResponse, is("json-web-token"));
    }

    @Test
    void testCreateUserAndAuthenticateUserIfUserIsNotFound() {
        // Given
        var authRequest = createValidGoogleAuthRequest();
        when(userServiceMock.findUserByEmail("test.test@gmail.com")).thenReturn(Optional.empty());
        when(userServiceMock.create(any(UserCreateDTO.class)))
                .thenReturn(new User("Sanguinius", "Sanguinius", "test.test@gmail.com", URI.create("https://www.test.com/image.png")));

        // When
        String authenticationResponse = sut.authenticate(authRequest);

        // Then
        UserCreateDTO expectedDto = new UserCreateDTO("Sanguinius", "Sanguinius", "test.test@gmail.com", URI.create("https://www.test.com/image.png"));
        verify(userServiceMock, times(1)).create(expectedDto);
        assertThat(authenticationResponse, is("json-web-token"));
    }

    private GoogleAuthRequest createValidGoogleAuthRequest() {
        GoogleAuthRequest googleAuthRequest = new GoogleAuthRequest();

        GoogleAuthRequest.GoogleBasicProfile basicProfile = googleAuthRequest.getGoogleBasicProfile();
        basicProfile.setName("Sanguinius");
        basicProfile.setGivenName("Blood Angels Primarch");
        basicProfile.setFamilyName("Blood Angels");
        basicProfile.setImageUrl("https://www.test.com/image.png");
        basicProfile.setEmail("test.test@gmail.com");

        GoogleAuthRequest.GoogleAuth googleAuth = googleAuthRequest.getGoogleAuth();
        googleAuth.setAccessToken("someAccessToken");
        googleAuth.setIdToken("someIdToken");
        googleAuth.setScope("scope");
        googleAuth.setExpiresIn("1000");
        googleAuth.setFirstIssuedAt("firstIssuedAt");
        googleAuth.setExpiresAt("expiresAt");

        return googleAuthRequest;
    }
}

class JWTGeneratorStub extends JWTGenerator {

    @Override
    public String generateTokenForUser(TokenGenerationParams params) {
        return "json-web-token";
    }
}
