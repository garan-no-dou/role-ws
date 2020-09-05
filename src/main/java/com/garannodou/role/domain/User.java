package com.garannodou.role.domain;

import lombok.Getter;

import java.net.URI;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.UUID.randomUUID;

public class User {
    @Getter
    private UUID id;

    @Getter
    // TODO: Add validation
    private String userName; //TODO: Encrypt field

    @Getter
    // TODO: Add validation
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

        validateEmail(email);

        this.id = randomUUID();
        this.userName = userName;
        this.nickName = nickName;
        this.email = email;
        this.imageUrl = imageUrl;
    }

    // TODO: Extract to separate Validator class?
    private void validateEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalStateException("Email is null or blank");
        } else {
            String emailRegex = "^(.+)@(.+)$";
            Pattern pattern = Pattern.compile(emailRegex);
            if (!pattern.matcher(email).matches()) {
                throw new IllegalStateException("Email has invalid format. Expected expression: (.+)@(.+)");
            }
        }
    }

}
