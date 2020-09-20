package com.garannodou.role.service;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.net.URI;

@EqualsAndHashCode
public class UserCreateDTO {
    @Getter
    private String userName;

    @Getter
    private String nickName;

    @Getter
    private String email;

    @Getter
    private URI imageUrl;

    public UserCreateDTO(String username, String nickName, String email, URI imageUrl) {
        this.userName = username;
        this.nickName = nickName;
        this.email = email;
        this.imageUrl = imageUrl;
    }
}
