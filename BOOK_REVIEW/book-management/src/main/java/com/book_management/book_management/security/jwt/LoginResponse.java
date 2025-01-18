package com.book_management.book_management.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class LoginResponse {
    @Getter
    @Setter
    private String id;
    @JsonIgnore
    private String jwtToken;

    private String name;
    private List<String> roles;

    public LoginResponse(String id,String username, List<String> roles, String jwtToken) {
        this.name = username;
        this.id=id;
        this.roles = roles;
        this.jwtToken = jwtToken;
    }

    public LoginResponse(String id, String username, List<String> roles) {
        this.name = username;
        this.id=id;
        this.roles = roles;

    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
