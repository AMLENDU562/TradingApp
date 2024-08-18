package com.spring.backend.Mapper;

import com.spring.backend.Dto.FastTradeTeamDto;
import com.spring.backend.Entity.Employee;
import com.spring.backend.Dto.EmployeeDto;
import com.spring.backend.Entity.FastTradeTeam;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class EmployeeMapper {

    public Employee EmployeeTo(EmployeeDto employeedto)
    {
        return new Employee(
          employeedto.getId(),
          employeedto.getName(),
          employeedto.getPassword(),
          employeedto.getEmail(),
          employeedto.getSponsorId(),
          employeedto.getMobileNumber(),
          employeedto.getPackages()

        );
    }

    public EmployeeDto EmployeeDtoTo(Employee Employee)
    {
        return new EmployeeDto(
          Employee.getId(),
          Employee.getName(),
          Employee.getPassword(),
          Employee.getEmail(),
          Employee.getSponsorId(),
          Employee.getMobileNumber(),
          Employee.getPackages()
        );
    }

    public static class FastTradeIncomeMapper {

        // Convert entity to DTO
        public static FastTradeTeamDto toDTO(FastTradeTeam entity) {
            if (entity == null) {
                return null;
            }

            FastTradeTeamDto dto = new FastTradeTeamDto();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setSponsorCode(entity.getSponsorCode());
            dto.setSponsorActivationAmount(entity.getSponsorActivationAmount());
            dto.setSponsorActivationDate(entity.getSponsorActivationDate());
            dto.setUserActivationAmount(entity.getUserActivationAmount());
            dto.setUserActivationDate(entity.getUserActivationDate());
            dto.setDays(entity.getDays());
            dto.setStatus(entity.getStatus());

            return dto;
        }

        // Convert DTO to entity
        public static FastTradeTeam toEntity(FastTradeTeamDto dto) {
            if (dto == null) {
                return null;
            }

            FastTradeTeam entity = new FastTradeTeam();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setSponsorCode(dto.getSponsorCode());
            entity.setSponsorActivationAmount(dto.getSponsorActivationAmount());
            entity.setSponsorActivationDate((Date) dto.getSponsorActivationDate());
            entity.setUserActivationAmount(dto.getUserActivationAmount());
            entity.setUserActivationDate((Date) dto.getUserActivationDate());
            entity.setDays(dto.getDays());
            entity.setStatus(dto.getStatus());

            return entity;
        }
    }
}
