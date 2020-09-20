package com.garannodou.role.controller;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class GoogleAuthRequest {

    @Valid
    private GoogleBasicProfile googleBasicProfile = new GoogleBasicProfile();
    private GoogleAuth googleAuth = new GoogleAuth();

    public GoogleAuthRequest() {
    }

    @Getter
    @Setter
    public class GoogleBasicProfile {
        @NotNull
        @Pattern(regexp = "^[a-zA-Z0-9-_\\s]+$",
                message = "Name has invalid format. Expected format: ^[a-zA-Z0-9-_\\s]+$")
        private String name;
        @NotNull
        @Pattern(regexp = "^[a-zA-Z0-9-_\\s]+$",
                message = "GivenName has invalid format. Expected format: ^[a-zA-Z0-9-_\\s]+$")
        private String givenName;
        @NotNull
        @Pattern(regexp = "^[a-zA-Z0-9-_\\s]+$",
                message = "FamilyName has invalid format. Expected format: ^[a-zA-Z0-9-_\\s]+$")
        private String familyName;
        @NotNull
        @URL
        private String imageUrl;
        @NotNull
        @Email(regexp = "^[A-Za-z0-9+_.-]+@([A-Za-z0-9.])+$",
                message = "Email has invalid format. Expected format: ^[A-Za-z0-9+_.-]+@(.+)$")
        private String email;

        public GoogleBasicProfile() {
        }
    }

    @Getter
    @Setter
    public class GoogleAuth {
        // TODO: Add validations to each field, once the content is clearer.
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
