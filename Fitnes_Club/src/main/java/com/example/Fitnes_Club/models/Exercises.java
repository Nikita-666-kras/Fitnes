package com.example.Fitnes_Club.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "exercises", schema = "schema", catalog = "FitnesBD")
public class Exercises {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long Id;
    @Column(name = "Name")
    private String Name;
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workouts workout;

}