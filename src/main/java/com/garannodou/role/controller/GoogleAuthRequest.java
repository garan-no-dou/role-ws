package com.garannodou.role.controller;

import lombok.Getter;
import lombok.Setter;

// TODO: Add concrete types and validations to each field, once the content is clearer.
@Getter
@Setter
public class GoogleAuthRequest {

    private GoogleBasicProfile googleBasicProfile;
    private GoogleAuthResponse googleAuthResponse;

    public GoogleAuthRequest() {
    }

    @Getter
    @Setter
    static class GoogleBasicProfile {
        private String id;
        private String name;
        private String givenName;
        private String familyName;
        private String imageUrl;
        private String email;

        public GoogleBasicProfile() {
        }
    }

    @Getter
    @Setter
    static class GoogleAuthResponse {
        private String accessToken;
        private String idToken;
        private String scope;
        private String expiresIn;
        private String firstIssuedAt;
        private String expiresAt;

        public GoogleAuthResponse() {
        }
    }

}
