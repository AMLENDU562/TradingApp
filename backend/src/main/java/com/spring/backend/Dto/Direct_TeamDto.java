package com.spring.backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Direct_TeamDto {

    private Integer teamId;
    private String name;
    private Float amount;
    private String commission;
    private Integer employeeId;
}
