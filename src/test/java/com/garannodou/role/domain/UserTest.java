package com.garannodou.role.domain;

import org.junit.Test; // TODO: Replace "org.junit.jupiter.Test" and update tests
import org.junit.jupiter.params.ParameterizedTest;

import java.net.URI;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

// TODO: Refactor tests using Junit 5
public class UserTest {

    @Test(expected = IllegalStateException.class)
    public void testFailsWhenTheUserNameIsNull() {
        User user = new User(null, "nickname", "user@email.com", URI.create("https://uri-example.com"));
    }

    @Test(expected = IllegalStateException.class)
    public void testFailsWhenTheUserNameIsBlank() {
        User user = new User(" ", "nickname", "user@email.com", URI.create("https://uri-example.com"));
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

    @Test(expected = IllegalStateException.class)
    public void testFailsWhenTheEmailIsNull() {
        User user = new User("username", "nickname", null, URI.create("https://uri-example.com"));
    }

    @Test(expected = IllegalStateException.class)
    public void testFailsWhenTheEmailIsBlank() {
        User user = new User("username", "nickname", " ", URI.create("https://uri-example.com"));
    }

    @Test(expected = IllegalStateException.class)
    public void testFailsWhenEmailDoesNotFollowRegex() {
        String invalidEmail = "invalidEmail";
        new User("username", "nickname", invalidEmail, URI.create("https://uri-example.com"));
    }

    @Test
    public void testOkayWhenEmailFollowsRegex() {
        String correctEmail = "correct@email.com";
        new User("username", "nickname", correctEmail, URI.create("https://uri-example.com"));
    }

    @Test
    public void testUsernameCanOnlyContainAlphanumerics () {
        String correctUsername = "Valid_username-89";
        new User(correctUsername, "nickname", "correct@email.com", URI.create("https://uri-example.com"));
    }

    @Test(expected = IllegalStateException.class)
    public void testUsernameCanNotContainSpecialCharacters () {
        String invalidUsername = "invalid!user?name";
        new User(invalidUsername, "nickname", "correct@email.com", URI.create("https://uri-example.com"));
    }

    @Test
    public void testNicknameCanOnlyContainAlphanumerics () {
        String correctNickname = "Valid_nickname-89";
        new User("username", correctNickname, "correct@email.com", URI.create("https://uri-example.com"));
    }

    @Test(expected = IllegalStateException.class)
    public void testNicknameCanNotContainSpecialCharacters () {
        String invalidNickname = "invalid!nickname?name";
        new User("username", invalidNickname, "correct@email.com", URI.create("https://uri-example.com"));
    }
}
