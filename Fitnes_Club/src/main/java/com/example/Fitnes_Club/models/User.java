package com.example.Fitnes_Club.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "User", schema = "schema", catalog = "FitnesBD")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long Id;
    @Column(name = "Name")
    private String Name;
    @Column(name = "Email")
    private String Email;
    @Column(name = "role")
    private String role;
    @Column(name = "password")
    private String password;

}
