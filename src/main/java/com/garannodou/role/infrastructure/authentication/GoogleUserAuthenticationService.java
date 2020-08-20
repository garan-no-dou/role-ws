package com.garannodou.role.infrastructure.authentication;

import com.garannodou.role.controller.GoogleAuthRequest;
import org.springframework.stereotype.Service;

@Service
public class GoogleUserAuthenticationService {

    public String authenticate(GoogleAuthRequest googleAuthRequest) {
        return "Authenticated"; // TODO: Implement authentication
    }

}
