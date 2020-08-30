package com.garannodou.role.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.garannodou.role.controller.GoogleAuthRequest.GoogleAuth;
import com.garannodou.role.controller.GoogleAuthRequest.GoogleBasicProfile;
import com.garannodou.role.infrastructure.authentication.GoogleUserAuthenticationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@WebMvcTest(UserController.class)
class UserControllerTest {

    // TODO: Input validation cases return 400

    @Autowired
    MockMvc mockMvc;
    @MockBean
    GoogleUserAuthenticationService authenticationService;
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testCallsServiceAndReturns201WithAuthToken() throws Exception {
        GoogleAuthRequest googleAuthRequest = createSampleGoogleAuthRequest();
        when(authenticationService.authenticate(any(GoogleAuthRequest.class)))
                .thenReturn("Authenticated. Name: " + googleAuthRequest.getGoogleBasicProfile().getName());

        MockHttpServletResponse response = mockMvc.perform(post("/authentication")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(googleAuthRequest)))
                .andReturn()
                .getResponse();

        verify(authenticationService, times(1)).authenticate(any(GoogleAuthRequest.class));
        assertThat(response.getStatus(), is(HttpStatus.CREATED.value()));
        assertThat(response.getContentAsString(), is("Authenticated. Name: Sanguinius"));
    }

    private GoogleAuthRequest createSampleGoogleAuthRequest() {
        GoogleAuthRequest googleAuthRequest = new GoogleAuthRequest();

        GoogleBasicProfile basicProfile = googleAuthRequest.getGoogleBasicProfile();
        basicProfile.setId("some-google-id");
        basicProfile.setName("Sanguinius");
        basicProfile.setGivenName("Blood Angels Primarch");
        basicProfile.setFamilyName("Blood Angels");
        basicProfile.setImageUrl("https://www.test.com/image.png");
        basicProfile.setEmail("test.test@gmail.com");

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