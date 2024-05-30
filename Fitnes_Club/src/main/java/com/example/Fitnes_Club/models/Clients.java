package com.example.Fitnes_Club.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "clients", schema = "schema", catalog = "FitnesBD")
public class Clients {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long Id;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
