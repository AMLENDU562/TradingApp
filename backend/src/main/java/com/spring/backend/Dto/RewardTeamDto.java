package com.spring.backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RewardTeamDto {
    private Integer id;
    private String name;
    private Integer employeeId;
    private Float Amount;

}
