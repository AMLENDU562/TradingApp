package com.spring.backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table
@Entity(name = "Employee")

public class Employee {
    @GeneratedValue(strategy =GenerationType.AUTO)
    @Id
            Integer id;
    @Column(name = "name",unique = true)
            String name;
    @Column(name="password")
        String password;

    @Column(name="email")
        String email;

    @Column(name="sponsorId",unique = true)
        String sponsorId;
    @Column(name="number")
        String mobileNumber;
    @Column(name="packages")
        String packages;


}
