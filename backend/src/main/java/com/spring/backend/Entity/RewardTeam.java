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

@Table(name="RewardTeam")
public class RewardTeam {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer Id;

    @ManyToOne
    @JoinColumn(name = "EmployeeId")
    Employee employee;

    @Column(name = "Name")
    private String name;

    @Column(name="Amount")
    private Float Amount;

}