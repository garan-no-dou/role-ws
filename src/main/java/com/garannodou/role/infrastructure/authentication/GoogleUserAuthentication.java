package com.garannodou.role.infrastructure.authentication;

import lombok.Getter;

import java.util.UUID;

import static java.util.UUID.randomUUID;

public class GoogleUserAuthentication {
    private UUID id;
    private UUID userId;
    private String accessToken;
    private String idToken;
    private String scope;
    private long expiresIn;
    private long firstIssuedAt;
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
