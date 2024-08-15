package com.spring.backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private String sponsorId;
    private String mobileNumber;
    private String packages;
}
