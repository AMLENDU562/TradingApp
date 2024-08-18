package com.spring.backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "FastTradeTeam") // Explicitly specify the table name
public class FastTradeTeam {

    @GeneratedValue(strategy = GenerationType.AUTO) // Use IDENTITY for auto-increment
    @Id
    Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "sponsorCode")
    private Integer sponsorCode;

    @Column(name = "sponsorActivationAmount")
    private Float sponsorActivationAmount;

    @Column(name = "sponsorActivationDate")
    private Date sponsorActivationDate;

    @ManyToOne // Adjust cascade types as needed
    @JoinColumn(name = "employee_id",unique = false) // Column in Direct_Team table that references Employee
    private Employee employee;

    @Column(name="userActivationAmount")
    private Float userActivationAmount;

    @Column(name="userActivationDate")
    private Date userActivationDate;

    @Column(name="Days")
    private Integer days;

    @Column(name = "Status")
    private Integer status;
}
