package com.garannodou.role.domain;

import lombok.Getter;

import java.net.URI;
import java.util.UUID;

import static java.util.UUID.randomUUID;

public class User {
    @Getter
    private UUID id;

    @Getter
    private String userName; // TODO: Encrypt field

    @Getter
    private String nickName; // TODO: Ask to user, by default userName

    @Getter
    private String email; // TODO: Encrypt field

    @Getter
    private URI imageUrl;

    public User(String username, String nickName, String email, URI imageUrl) {
        if (username == null || username.isBlank()) {
            throw new IllegalStateException("UserName is invalid");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalStateException("Email is null or blank");
        }
        if (nickName == null || nickName.isBlank()) {
            nickName = username;
        }

        this.id = randomUUID();
        this.userName = username;
        this.nickName = nickName;
        this.email = email;
        this.imageUrl = imageUrl;
    }

}
