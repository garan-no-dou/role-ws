package com.garannodou.role.service;

import com.garannodou.role.domain.User;
import com.garannodou.role.domain.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private UserRepository userRepository;
    private UserService sut;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        sut = new UserService(userRepository);
    }

    @Test
    void testReturnEmptyIfUserIsNotFound() {
        // Given
        when(userRepository.findByEmail("user.not.exist@gmail.com")).thenReturn(Optional.empty());

        // When
        Optional<User> optUser = sut.findUserByEmail("user.not.exist@gmail.com");

        // Then
        verify(userRepository, times(1)).findByEmail("user.not.exist@gmail.com");
        assertTrue(optUser.isEmpty());
    }

    @Test
    void testReturnUserIfUserExists() {
        // Given
        when(userRepository.findByEmail("user@gmail.com"))
                .thenReturn(Optional.of(new User("username", "nickname", "user@gmail.com", URI.create("https://test.com"))));

        // When
        Optional<User> optUser = sut.findUserByEmail("user@gmail.com");

        // Then
        verify(userRepository, times(1)).findByEmail("user@gmail.com");
        assertTrue(optUser.isPresent());
    }

    @Test
    void testCreatesUserIfEmailDoesNotExist() {
        // Given
        when(userRepository.findByEmail("user@gmail.com"))
                .thenReturn(Optional.empty());
        when(userRepository.save(any(User.class)))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        // When
        User createdUser = sut.create(new UserCreateDTO("Sanguinius", "Sanguinius", "user@gmail.com", URI.create("https://www.test.com/image.png")));

        // Then
        verify(userRepository, times(1)).save(any(User.class));
        assertThat(createdUser.getId(), is(notNullValue()));
        assertThat(createdUser.getUserName(), is("Sanguinius"));
        assertThat(createdUser.getNickName(), is("Sanguinius"));
        assertThat(createdUser.getEmail(), is("user@gmail.com"));
        assertThat(createdUser.getImageUrl(), is(URI.create("https://www.test.com/image.png")));
    }

    @Test
    void testCreateUserThrowsExceptionIfEmailAlreadyExists() {
        // Given
        when(userRepository.findByEmail("user@gmail.com"))
                .thenReturn(Optional.of(new User("username", "nickname", "user@gmail.com", URI.create("https://test.com"))));

        // When
        assertThrows(EmailAlreadyExistsException.class, () -> {
            sut.create(new UserCreateDTO("Sanguinius", "Sanguinius", "user@gmail.com", URI.create("https://www.test.com/image.png")));
        });
    }

}
