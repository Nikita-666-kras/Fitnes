package com.example.Fitnes_Club.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
    @Table(name = "coach", schema = "schema", catalog = "FitnesBD")
public class Coach {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long Id;
    @Column(name = "specialization")
    private String specialization;
    @Column(name = "name")
    private String name;
    @OneToOne
    @JoinColumn(name  = "User_id")
    private User user;
}
