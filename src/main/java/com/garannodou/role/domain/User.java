package com.garannodou.role.domain;

import lombok.Getter;

import java.net.URI;
import java.util.UUID;

import static java.util.UUID.randomUUID;

public class User {
    @Getter
    private UUID id;

    @Getter
    private String userName; //TODO: Encrypt field

    @Getter
    private String nickName; //TODO: Ask to user, by default userName

    @Getter
    private String email; //TODO: Encrypt field

    @Getter
    private URI imageUrl;

    public User(String userName, String nickName, String email, URI imageUrl) {
        if (userName == null || userName.isBlank()) {
            throw new IllegalStateException("UserName is invalid");
        }

        if (nickName == null || nickName.isBlank()) {
            nickName = userName;
        }

        if (email == null || email.isBlank()) { //TODO: Check email pattern
            throw new IllegalStateException("Email is invalid");
        }

        this.id = randomUUID();
        this.userName = userName;
        this.nickName = nickName;
        this.email = email;
        this.imageUrl = imageUrl;
    }

}
