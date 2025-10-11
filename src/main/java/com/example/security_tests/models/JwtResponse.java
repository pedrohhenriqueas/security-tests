package com.example.security_tests.models;

import java.util.List;

public class JwtResponse {
    private String token;
    private List<String> roles;
    private int customerId;

    public JwtResponse(String accessToken, List<String> roles, int customerId) {
        this.token = "Bearer " + accessToken;
        this.roles = roles;
        this.customerId = customerId;
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

}
