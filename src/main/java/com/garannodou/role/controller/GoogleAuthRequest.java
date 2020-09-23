package com.garannodou.role.controller;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class GoogleAuthRequest {

    @Getter(onMethod = @__({@Valid}))
    @Setter(onParam = @__({@Valid}))
    protected GoogleBasicProfile googleBasicProfile = new GoogleBasicProfile();
    @Getter(onMethod = @__({@Valid}))
    @Setter(onParam = @__({@Valid}))
    protected GoogleAuth googleAuth = new GoogleAuth();

    public GoogleAuthRequest() {
    }

    public class GoogleBasicProfile {
        @Getter(onMethod =
        @__({
                @NotNull,
                @Pattern(regexp = "^[a-zA-Z0-9-_\\s]+$",
                        message = "Name has invalid format. Expected format: ^[a-zA-Z0-9-_\\s]+$"),
                @Size(min = 10, max = 50)
        })
        )
        @Setter(onParam =
        @__({
                @NotNull,
                @Pattern(regexp = "^[a-zA-Z0-9-_\\s]+$",
                        message = "Name has invalid format. Expected format: ^[a-zA-Z0-9-_\\s]+$"),
                @Size(min = 10, max = 50)
        })
        )
        private String name;

        @Getter(onMethod =
        @__({
                @NotNull,
                @Pattern(regexp = "^[a-zA-Z0-9-_\\s]+$",
                        message = "GivenName has invalid format. Expected format: ^[a-zA-Z0-9-_\\s]+$"),
                @Size(min = 10, max = 50)
        })
        )
        @Setter(onParam =
        @__({
                @NotNull,
                @Pattern(regexp = "^[a-zA-Z0-9-_\\s]+$",
                        message = "GivenName has invalid format. Expected format: ^[a-zA-Z0-9-_\\s]+$"),
                @Size(min = 10, max = 50)
        })
        )
        private String givenName;
        @Getter(onMethod =
        @__({
                @NotNull,
                @Pattern(regexp = "^[a-zA-Z0-9-_\\s]+$",
                        message = "FamilyName has invalid format. Expected format: ^[a-zA-Z0-9-_\\s]+$"),
                @Size(min = 10, max = 100)
        })
        )
        @Setter(onParam =
        @__({
                @NotNull,
                @Pattern(regexp = "^[a-zA-Z0-9-_\\s]+$",
                        message = "FamilyName has invalid format. Expected format: ^[a-zA-Z0-9-_\\s]+$"),
                @Size(min = 10, max = 100)
        })
        )
        private String familyName;
        @Getter(onMethod =
        @__({
                @NotNull,
                @URL,
                @Size(min = 10, max = 100)
        })
        )
        @Setter(onParam =
        @__({
                @NotNull,
                @URL,
                @Size(min = 10, max = 100)
        })
        )
        private String imageUrl;
        @Getter(onMethod =
        @__({
                @NotNull,
                @Email(regexp = "^[A-Za-z0-9+_.-]+@([A-Za-z0-9.])+$",
                        message = "Email has invalid format. Expected format: ^[A-Za-z0-9+_.-]+@(.+)$"),
                @Size(min = 10, max = 100)
        })
        )
        @Setter(onParam =
        @__({
                @NotNull,
                @Email(regexp = "^[A-Za-z0-9+_.-]+@([A-Za-z0-9.])+$",
                        message = "Email has invalid format. Expected format: ^[A-Za-z0-9+_.-]+@(.+)$"),
                @Size(min = 10, max = 100)
        })
        )
        private String email;

        public GoogleBasicProfile() {
        }
    }

    public class GoogleAuth {
        // TODO: Add validations to each field, once the content is clearer.
        @Getter(onMethod =
        @__({
                @NotNull,
                @Size(min = 10, max = 100)
        })
        )
        @Setter(onParam =
        @__({
                @NotNull,
                @Size(min = 10, max = 100)
        })
        )
        private String accessToken;
        @Getter(onMethod =
        @__({
                @NotNull,
                @Size(min = 10, max = 100)
        })
        )
        @Setter(onParam =
        @__({
                @NotNull,
                @Size(min = 10, max = 100)
        })
        )
        private String idToken;
        @Getter(onMethod =
        @__({
                @NotNull,
                @Size(min = 10, max = 100)
        })
        )
        @Setter(onParam =
        @__({
                @NotNull,
                @Size(min = 10, max = 100)
        })
        )
        private String scope;
        @Getter(onMethod =
        @__({
                @NotNull,
                @Size(min = 10, max = 100)
        })
        )
        @Setter(onParam =
        @__({
                @NotNull,
                @Size(min = 10, max = 100)
        })
        )
        private String expiresIn;
        @Getter(onMethod =
        @__({
                @NotNull,
                @Size(min = 10, max = 100)
        })
        )
        @Setter(onParam =
        @__({
                @NotNull,
                @Size(min = 10, max = 100)
        })
        )
        private String firstIssuedAt;
        @Getter(onMethod =
        @__({
                @NotNull,
                @Size(min = 10, max = 100)
        })
        )
        @Setter(onParam =
        @__({
                @NotNull,
                @Size(min = 10, max = 100)
        })
        )
        private String expiresAt;

        public GoogleAuth() {
        }
    }

}
