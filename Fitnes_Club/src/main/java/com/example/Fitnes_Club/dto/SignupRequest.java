package com.example.Fitnes_Club.dto;

import lombok.Data;

import java.util.Set;

@Data
public class SignupRequest {
    private String Name;
    private String Email;

    private String password;

    private Set<String> roles;
}
