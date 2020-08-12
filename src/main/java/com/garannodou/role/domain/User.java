package com.garannodou.role.domain;

import java.net.URI;
import java.util.UUID;

import static java.util.UUID.randomUUID;

public class User {
    private UUID id;

    private String userName; //TODO: Encrypt field

    private String nickName; //TODO: Ask to user, by default userName

    private String email; //TODO: Encrypt field

    private URI imageUrl;

    public User(String userName, String nickName, String email, URI imageUrl) {
        if (userName == null || userName.isBlank()) {
            throw new IllegalStateException("UserName is invalid");
        }

        if (nickName == null || nickName.isBlank()) {
            nickName = userName;
        }

        if (email == null || email.isEmpty()) { //TODO: Check email pattern
            throw new IllegalStateException("Email is invalid");
        }

        this.id = randomUUID();
        this.userName = userName;
        this.nickName = nickName;
        this.email = email;
        this.imageUrl = imageUrl;
    }
}
