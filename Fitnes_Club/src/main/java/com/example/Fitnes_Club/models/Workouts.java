package com.example.Fitnes_Club.models;

import jakarta.persistence.*;

import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "workouts", schema = "schema", catalog = "FitnesBD")
public class Workouts {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long Id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "start_date")
    private String start_date;
    @Column(name = "end_date")
    private String end_date;





}
