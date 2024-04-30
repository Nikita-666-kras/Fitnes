package com.example.Svinopark.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "workouts", schema = "schema", catalog = "FitnesBD")
public class Workouts {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long Id;
    @Column(name = "Name")
    private String Name;
    @Column(name = "Age")
    private int Age;
    @Column(name = "role")
    private String role;
    @Column(name = "password")
    private String password;
    @ManyToOne
    @JoinColumn(name  = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name  = "exercises_id")
    private Exercises exercises;

}
