package com.garannodou.role.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URI;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class UserTest {

    @Test
    public void testFailsWhenTheUserNameIsNull() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            new User(null, "nickname", "user@email.com", URI.create("https://uri-example.com"));
        });
    }

    @Test
    public void testFailsWhenTheUserNameIsBlank() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            new User(" ", "nickname", "user@email.com", URI.create("https://uri-example.com"));
        });
    }

    @Test
    public void testNickNameIsEqualToTheUserNameWhenTheNickNameIsNull() {
        User user = new User("username", null, "user@email.com", URI.create("https://uri-example.com"));
        assertThat(user.getNickName(), is(equalTo(user.getUserName())));
    }

    @Test
    public void testNickNameIsEqualToTheUserNameWhenTheNickNameIsBlank() {
        User user = new User("username", " ", "user@email.com", URI.create("https://uri-example.com"));
        assertThat(user.getNickName(), is(equalTo(user.getUserName())));
    }

    @Test
    public void testFailsWhenTheEmailIsNull() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            new User("username", "nickname", null, URI.create("https://uri-example.com"));
        });
    }

    @Test
    public void testFailsWhenTheEmailIsBlank() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            new User("username", "nickname", " ", URI.create("https://uri-example.com"));
        });
    }

}
