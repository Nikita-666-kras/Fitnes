package com.example.Fitnes_Club.models;

import jakarta.persistence.*;
import lombok.Data;

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



}