package com.spring.backend.Mapper;

import com.spring.backend.Dto.FastTradeTeamDto;
import com.spring.backend.Entity.Employee;
import com.spring.backend.Entity.FastTradeTeam;
import com.spring.backend.Exception.FastTradeException;
import com.spring.backend.Respository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FastTradeMapper {

    private final EmployeeRepository employeeRepository;

    public FastTradeTeamDto toDTO(FastTradeTeam entity) {
        if (entity == null) {
            return null;
        }

        FastTradeTeamDto dto = new FastTradeTeamDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSponsorCode(entity.getSponsorCode());
        dto.setSponsorActivationAmount(entity.getSponsorActivationAmount());
        dto.setEmployeeId(entity.getEmployee() != null ? entity.getEmployee().getId() : null);
        dto.setSponsorActivationDate(entity.getSponsorActivationDate());
        dto.setUserActivationAmount(entity.getUserActivationAmount());
        dto.setUserActivationDate(entity.getUserActivationDate());
        dto.setDays(entity.getDays());
        dto.setStatus(entity.getStatus());

        return dto;
    }

    public FastTradeTeam toEntity(FastTradeTeamDto dto) {
        if (dto == null) {
            return null;
        }

        Employee emp = employeeRepository.findById(dto.getEmployeeId())
                .orElseThrow(() -> new FastTradeException("Employee Id " + dto.getEmployeeId() + " cannot be found"));

        FastTradeTeam entity = new FastTradeTeam();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setSponsorCode(dto.getSponsorCode());
        entity.setSponsorActivationAmount(dto.getSponsorActivationAmount());
        entity.setSponsorActivationDate(convertToSqlDate(dto.getSponsorActivationDate()));
        entity.setUserActivationAmount(dto.getUserActivationAmount());
        entity.setUserActivationDate(convertToSqlDate(dto.getUserActivationDate()));
        entity.setEmployee(emp);
        entity.setDays(dto.getDays());
        entity.setStatus(dto.getStatus());

        return entity;
    }

    // Helper method to convert java.util.Date to java.sql.Date
    private Date convertToSqlDate(java.util.Date utilDate) {
        return utilDate != null ? new Date(utilDate.getTime()) : null;
    }
}
