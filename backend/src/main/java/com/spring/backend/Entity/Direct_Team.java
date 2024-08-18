package com.spring.backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "direct_team") // Explicitly specify the table name
public class Direct_Team {

    @GeneratedValue(strategy = GenerationType.AUTO) // Use IDENTITY for auto-increment
    @Id
        Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "amount")
    private Float amount;

    @Column(name = "commission")
    private String commission;

    @ManyToOne // Adjust cascade types as needed
    @JoinColumn(name = "employee_id",unique = false) // Column in Direct_Team table that references Employee
    private Employee employee;
}
