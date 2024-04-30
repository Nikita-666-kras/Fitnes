package com.example.Svinopark.dto;

import lombok.Data;

@Data
public class SignupRequest {
    private String Name;
    private String email;
    private String password;
}
