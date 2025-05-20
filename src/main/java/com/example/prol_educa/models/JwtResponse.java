package com.example.prol_educa.models;

import java.util.List;

public class JwtResponse {
    private String token;
    private List<String> roles;

    public JwtResponse(String accessToken, List<String> roles) {
        this.token = "Bearer " + accessToken;
        this.roles = roles;
    }

    public JwtResponse(String accessToken) {
        this.token = "Bearer " + accessToken;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public List<String> getRoles() {
        return roles;
    }
}
