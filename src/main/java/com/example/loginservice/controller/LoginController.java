package com.example.loginservice.controller;

import com.example.loginservice.dto.AuthResponseDTO;
import com.example.loginservice.service.AuthenticationService;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public AuthResponseDTO login(JwtAuthenticationToken authenticationToken) {
        Map<String, Object> authData = authenticationService.processJwtToken(authenticationToken);
        return new AuthResponseDTO(
                (String) authData.get("username"),
                authData.get("roles"),
                (Map<String, Object>) authData.get("claims")
        );
    }
}
