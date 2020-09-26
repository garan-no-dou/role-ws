package com.garannodou.role.controller;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.validation.Valid;
import javax.validation.constraints.*;


@Getter
@Setter
public class GoogleAuthRequest {

    @Valid
    protected GoogleBasicProfile googleBasicProfile = new GoogleBasicProfile();
    @Valid
    protected GoogleAuth googleAuth = new GoogleAuth();

    public GoogleAuthRequest() {
    }

    @Getter
    @Setter
    public class GoogleBasicProfile {
        @NotNull
        @Pattern(regexp = "^[a-zA-Z0-9-_\\s]+$",
                message= "Name has invalid format. Expected format: ^[a-zA-Z0-9-_\\s]+$")
        @Size(min = 10, max = 50)
        private String name;
        @NotNull
        @Pattern(regexp = "^[a-zA-Z0-9-_\\s]+$",
                message = "GivenName has invalid format. Expected format: ^[a-zA-Z0-9-_\\s]+$")
        @Size(min = 10, max = 50)
        private String givenName;
        @NotNull
        @Pattern(regexp = "^[a-zA-Z0-9-_\\s]+$",
                message = "FamilyName has invalid format. Expected format: ^[a-zA-Z0-9-_\\s]+$")
        @Size(min = 10, max = 100)
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
        @Size(min = 10, max = 100)
        private String accessToken;
        @NotNull
        @Size(min = 10, max = 100)
        private String idToken;
        @NotNull
        @Size(min = 1, max = 100)
        private String scope;
        @NotNull
        @Size(min = 1, max = 100)
        private String expiresIn;
        @NotNull
        @Size(min = 1, max = 100)
        private String firstIssuedAt;
        @NotNull
        @Size(min = 1, max = 100)
        private String expiresAt;

        public GoogleAuth() {
        }
    }

}
