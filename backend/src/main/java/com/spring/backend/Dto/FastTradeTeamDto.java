package com.spring.backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FastTradeTeamDto {


        private Integer id;
        private String name;
        private Integer sponsorCode;
        private Float sponsorActivationAmount;
        private Date sponsorActivationDate;
        private Integer employeeId;
        private Float userActivationAmount;
        private Date userActivationDate;
        private Integer days;
        private Integer status;
}
