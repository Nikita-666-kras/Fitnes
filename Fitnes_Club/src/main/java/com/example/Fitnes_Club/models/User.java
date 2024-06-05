package com.example.Fitnes_Club.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "User", schema = "schema", catalog = "FitnesBD")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "name")
    private String Name;
    @Column(name = "email")
    private String Email;
    @Column(name = "password")
    private String password;
    @Column(name = "img")
    private String img;



    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "User_Role", joinColumns = @JoinColumn(name = "user_id"),schema = "schema")
    @Column(name = "role")
    private Set<String> roles = new HashSet<>();

}
