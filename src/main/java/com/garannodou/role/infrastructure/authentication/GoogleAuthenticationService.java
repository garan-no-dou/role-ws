package com.garannodou.role.infrastructure.authentication;

import com.garannodou.role.controller.GoogleAuthRequest;
import com.garannodou.role.controller.GoogleAuthRequest.GoogleBasicProfile;
import com.garannodou.role.domain.User;
import com.garannodou.role.service.UserCreateDTO;
import com.garannodou.role.service.UserService;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Optional;

@Service
public class GoogleAuthenticationService {
    private UserService userService;

    public GoogleAuthenticationService(UserService userService) {
        this.userService = userService;
    }

    public String authenticate(GoogleAuthRequest googleAuthRequest) {
        var googleBasicProfile = googleAuthRequest.getGoogleBasicProfile();
        String email = googleBasicProfile.getEmail();
        Optional<User> maybeUser = userService.findUserByEmail(email);

        User user = null;
        if (maybeUser.isEmpty()) {
            UserCreateDTO userCreateDTO = createUserCreateDTOFrom(googleBasicProfile);

            user = userService.create(userCreateDTO);
        } else {
            user = maybeUser.get();
        }
        // Goodle
        // TODO: Authenticate google user
        return "Authenticated " + user.getUserName(); // TODO: Implement authentication
    }

    private UserCreateDTO createUserCreateDTOFrom(GoogleBasicProfile googleBasicProfile) {
        UserCreateDTO userCreateDTO = new UserCreateDTO(
                googleBasicProfile.getName(),
                googleBasicProfile.getName(),
                googleBasicProfile.getEmail(),
                URI.create(googleBasicProfile.getImageUrl())
        );
        return userCreateDTO;
    }

}
