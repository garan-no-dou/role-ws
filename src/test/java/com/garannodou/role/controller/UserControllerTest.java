package com.garannodou.role.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.garannodou.role.controller.GoogleAuthRequest.GoogleAuth;
import com.garannodou.role.controller.GoogleAuthRequest.GoogleBasicProfile;
import com.garannodou.role.infrastructure.authentication.GoogleAuthenticationFacade;
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
    GoogleAuthenticationFacade authenticationService;
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testCallsServiceAndReturns201WithAuthToken() throws Exception {
        GoogleAuthRequest googleAuthRequest = createValidGoogleAuthRequest();
        when(authenticationService.authenticate(any(GoogleAuthRequest.class)))
                .thenReturn("Authenticated. Name: " + googleAuthRequest.getGoogleBasicProfile().getName());

        MockHttpServletResponse response = mockMvc.perform(post("/authentication")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(googleAuthRequest)))
                .andReturn()
                .getResponse();

        assertThat(response.getStatus(), is(HttpStatus.CREATED.value()));
        assertThat(response.getContentAsString(), is("Authenticated. Name: Sanguinius"));
        verify(authenticationService, times(1)).authenticate(any(GoogleAuthRequest.class));
    }

    @Test
    public void testValidationErrorWhenEmailIsInvalid() throws Exception {
        GoogleAuthRequest request = createValidGoogleAuthRequest();
        GoogleBasicProfile googleBasicProfile = request.getGoogleBasicProfile();
        googleBasicProfile.setEmail("invalidEmail");

        MockHttpServletResponse response = mockMvc.perform(post("/authentication")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andReturn()
                .getResponse();

        assertThat(response.getStatus(), is(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    public void testValidationErrorWhenGivenNameIsInvalid() throws Exception {
        GoogleAuthRequest request = createValidGoogleAuthRequest();
        GoogleBasicProfile googleBasicProfile = request.getGoogleBasicProfile();
        googleBasicProfile.setGivenName("invalid!? given *name");

        MockHttpServletResponse response = mockMvc.perform(post("/authentication")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andReturn()
                .getResponse();

        assertThat(response.getStatus(), is(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    public void testValidationErrorWhenNameIsInvalid() throws Exception {
        GoogleAuthRequest request = createValidGoogleAuthRequest();
        GoogleBasicProfile googleBasicProfile = request.getGoogleBasicProfile();
        googleBasicProfile.setName("invalid!? *name");

        MockHttpServletResponse response = mockMvc.perform(post("/authentication")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andReturn()
                .getResponse();

        assertThat(response.getStatus(), is(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    public void testValidationErrorWhenFamilyNameIsInvalid() throws Exception {
        GoogleAuthRequest request = createValidGoogleAuthRequest();
        GoogleBasicProfile googleBasicProfile = request.getGoogleBasicProfile();
        googleBasicProfile.setFamilyName("invalid!?family *name");

        MockHttpServletResponse response = mockMvc.perform(post("/authentication")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andReturn()
                .getResponse();

        assertThat(response.getStatus(), is(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    public void testValidationErrorWhenURLIsInvalid() throws Exception {
        GoogleAuthRequest request = createValidGoogleAuthRequest();
        GoogleBasicProfile googleBasicProfile = request.getGoogleBasicProfile();
        googleBasicProfile.setImageUrl("this is notA URL");

        MockHttpServletResponse response = mockMvc.perform(post("/authentication")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andReturn()
                .getResponse();

        assertThat(response.getStatus(), is(HttpStatus.BAD_REQUEST.value()));
    }

    private GoogleAuthRequest createValidGoogleAuthRequest() {
        GoogleAuthRequest googleAuthRequest = new GoogleAuthRequest();

        GoogleBasicProfile basicProfile = googleAuthRequest.getGoogleBasicProfile();
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