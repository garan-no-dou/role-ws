package com.garannodou.role.infrastructure.authentication;

import com.garannodou.role.controller.GoogleAuthRequest;
import com.garannodou.role.controller.GoogleAuthRequest.GoogleBasicProfile;
import com.garannodou.role.domain.User;
import com.garannodou.role.service.UserCreateDTO;
import com.garannodou.role.service.UserService;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Optional;

import static com.garannodou.role.infrastructure.authentication.JWTGenerator.TokenGenerationParams;
import static io.jsonwebtoken.SignatureAlgorithm.HS256;

@Service
public class GoogleAuthenticationFacade {

    private final UserService userService;
    private final JWTGenerator jwtGenerator;
    private final String url;

    public GoogleAuthenticationFacade(UserService userService, JWTGenerator jwtGenerator,
                                      @Value("${app.backend.url}") String url) {
        this.userService = userService;
        this.jwtGenerator = jwtGenerator;
        this.url = url;
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

        return jwtGenerator.generateTokenForUser(new TokenGenerationParams(user.getId(),
                Keys.secretKeyFor(HS256),  // TODO: Extract key to env var
                url,
                "user"));
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
