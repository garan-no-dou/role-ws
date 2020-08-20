package com.garannodou.role.controller;

import com.garannodou.role.infrastructure.authentication.GoogleUserAuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private GoogleUserAuthenticationService authenticationService;

    public UserController(GoogleUserAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/authentication")
    public ResponseEntity<String> authenticateGoogleUser(@RequestBody GoogleAuthRequest request) {
        String response = authenticationService.authenticate(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
