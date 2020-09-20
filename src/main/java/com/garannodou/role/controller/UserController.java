package com.garannodou.role.controller;

import com.garannodou.role.infrastructure.authentication.GoogleAuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "${app.frontend.url}")
public class UserController {

    private GoogleAuthenticationService authenticationService;

    public UserController(GoogleAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/authentication") // TODO: Change URL to reflect Google
    public ResponseEntity<String> authenticateGoogleUser(@RequestBody @Valid GoogleAuthRequest request) {
        String response = authenticationService.authenticate(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
