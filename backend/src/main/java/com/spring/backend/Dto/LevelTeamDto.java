package com.spring.backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LevelTeamDto {
    private Integer id;
    private Integer sponsorId;
    private String name;
    private String amount;
    private Integer levelTradeIncome;
    private Integer level;
    private Integer employeeId;


}
