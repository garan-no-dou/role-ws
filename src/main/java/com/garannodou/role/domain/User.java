package com.garannodou.role.domain;

import lombok.Getter;

import java.net.URI;
import java.util.UUID;
import java.util.regex.Pattern;

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

    public static final String USERNAME_REGEX = "^[a-zA-Z0-9-_]+$";
    public static final String EMAIL_REGEX = "^(.+)@(.+)$";

    public User(String username, String nickName, String email, URI imageUrl) {
        validateUsername(username);
        validateEmail(email);

        if (nickName == null || nickName.isBlank()) { // TODO: Replace nickname parameter by Optional<String>
            nickName = username;
        } else {
            validateNickname(nickName);
        }

        this.id = randomUUID();
        this.userName = username;
        this.nickName = nickName;
        this.email = email;
        this.imageUrl = imageUrl;
    }

    // TODO: This is input validation, move it to the controller.
    private void validateUsername(String username) {
        if (username == null || username.isBlank()) {
            throw new IllegalStateException("UserName is invalid");
        } else {
            var validationErrorMessage = "Username has invalid format. Expected expression: ^[a-zA-Z0-9-_]+$";
            validateWithRegex(username, USERNAME_REGEX, validationErrorMessage);
        }
    }

    // TODO: This is input validation, move it to the controller.
    private void validateNickname(String nickName) {
        String validationErrorMessage = "Nickname has invalid format. Expected expression: ^[a-zA-Z0-9-_]+$";
        validateWithRegex(nickName, USERNAME_REGEX, validationErrorMessage);
    }

    // TODO: This is input validation, move it to the controller.
    private void validateEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalStateException("Email is null or blank");
        } else {
            String validationErrorMessage = "Email has invalid format. Expected expression: (.+)@(.+)";
            validateWithRegex(email, EMAIL_REGEX, validationErrorMessage);
        }
    }

    private void validateWithRegex(String email, String regex, String validationErrorMessage) {
        Pattern pattern = Pattern.compile(regex);
        if (!pattern.matcher(email).matches()) {
            throw new IllegalStateException(validationErrorMessage);
        }
    }

}
