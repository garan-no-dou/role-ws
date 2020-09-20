package com.garannodou.role;

import com.garannodou.role.domain.User;
import com.garannodou.role.domain.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class RoleWsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoleWsApplication.class, args);
    }

    @Bean // TODO: Remove when UserRepository is implemented
    public UserRepository userRepository() {
        return new UserRepository() {
            @Override
            public Optional<User> findByEmail(String email) {
                return Optional.empty();
            }

            @Override
            public User save(User user) {
                return user;
            }
        };
    }

}
