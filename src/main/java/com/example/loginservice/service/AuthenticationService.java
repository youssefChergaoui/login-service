package com.example.loginservice.service;

import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {

    public Map<String, Object> processJwtToken(JwtAuthenticationToken authenticationToken) {
        String username = authenticationToken.getName();
        Object roles = authenticationToken.getAuthorities();
        Map<String, Object> claims = authenticationToken.getTokenAttributes();

        Map<String, Object> response = new HashMap<>();
        response.put("username", username);
        response.put("roles", roles);
        response.put("claims", claims);

        return response;
    }
}
