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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY for auto-increment
    @Column(name = "team_id") // Explicitly specify the column name
    private Integer teamId;

    @Column(name = "name")
    private String name;

    @Column(name = "amount")
    private Float amount;

    @Column(name = "commission")
    private String commission;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) // Adjust cascade types as needed
    @JoinColumn(name = "employee_id") // Column in Direct_Team table that references Employee
    private Employee employee;
}
