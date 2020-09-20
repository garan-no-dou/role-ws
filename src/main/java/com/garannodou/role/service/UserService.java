package com.garannodou.role.service;

import com.garannodou.role.domain.User;
import com.garannodou.role.domain.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    // TODO: Should be transactional
    public User create(UserCreateDTO userCreateDTO) {
        Optional<User> optUser = userRepository.findByEmail(userCreateDTO.getEmail());
        if (optUser.isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        User user = new User(userCreateDTO.getUserName(),
                userCreateDTO.getNickName(),
                userCreateDTO.getEmail(),
                userCreateDTO.getImageUrl());

        return userRepository.save(user);
    }

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
