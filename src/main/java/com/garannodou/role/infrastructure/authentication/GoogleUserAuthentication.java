package com.garannodou.role.infrastructure.authentication;

import lombok.Getter;

import java.util.UUID;

import static java.util.UUID.randomUUID;

public class GoogleUserAuthentication {
    @Getter
    private UUID id;
    @Getter
    private UUID userId;
    @Getter
    private String accessToken;
    @Getter
    private String idToken;
    @Getter
    private String scope;
    @Getter
    private long expiresIn;
    @Getter
    private long firstIssuedAt;
    @Getter
    private long expiresAt;

    public GoogleUserAuthentication(UUID userId, String accessToken, String idToken, String scope, long expiresIn,
                                    long firstIssuedAt, long expiresAt) {
        this.id = randomUUID();
        this.userId = userId;
        this.accessToken = accessToken;
        this.idToken = idToken;
        this.scope = scope;
        this.expiresIn = expiresIn;
        this.firstIssuedAt = firstIssuedAt;
        this.expiresAt = expiresAt;
    }
}
