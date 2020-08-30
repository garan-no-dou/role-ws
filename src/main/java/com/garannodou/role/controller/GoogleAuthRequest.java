package com.garannodou.role.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

// TODO: Add concrete types and validations to each field, once the content is clearer.
@Getter
@Setter
public class GoogleAuthRequest {

    private GoogleBasicProfile googleBasicProfile = new GoogleBasicProfile();
    private GoogleAuth googleAuth = new GoogleAuth();

    public GoogleAuthRequest() {
    }

    @Getter
    @Setter
    class GoogleBasicProfile {
        @NotNull
        private String id;
        @NotNull
        private String name;
        @NotNull
        private String givenName;
        @NotNull
        private String familyName;
        @NotNull
        private String imageUrl;
        @NotNull
        private String email;

        public GoogleBasicProfile() {
        }
    }

    @Getter
    @Setter
    class GoogleAuth {
        @NotNull
        private String accessToken;
        @NotNull
        private String idToken;
        @NotNull
        private String scope;
        @NotNull
        private String expiresIn;
        @NotNull
        private String firstIssuedAt;
        @NotNull
        private String expiresAt;

        public GoogleAuth() {
        }
    }

}
