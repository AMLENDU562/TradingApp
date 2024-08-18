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
@Table(name="LevelTeam")
@Entity
public class LevelTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "sponsor-id")
    private Integer sponsorId;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;

    @Column(name="name")
    private String name;

    @Column(name="amount")
    private String amount;

    @Column(name="LevelTradeIncome")
    private Integer levelTradeIncome;

    @Column(name="level")
    private Integer level;

}
