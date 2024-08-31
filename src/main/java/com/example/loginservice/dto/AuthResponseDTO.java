package com.example.loginservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponseDTO {

    private String username;
    private Object roles;
    private Map<String, Object> claims;
}
