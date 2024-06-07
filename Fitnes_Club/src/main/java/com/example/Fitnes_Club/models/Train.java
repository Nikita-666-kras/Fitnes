package com.example.Fitnes_Club.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Train", schema = "schema", catalog = "FitnesBD")
public class Train {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long Id;
    @ManyToOne
    @JoinColumn(name  = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name  = "coach_id")
    private Coach coach;
    @ManyToOne
    @JoinColumn(name = "exercises_id")
    private Exercises exercises;
    @ManyToOne
    @JoinColumn(name = "workouts_id")
    private Workouts workouts;
}
