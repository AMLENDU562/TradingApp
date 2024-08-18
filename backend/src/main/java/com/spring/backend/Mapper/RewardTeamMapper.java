package com.spring.backend.Mapper;

import com.spring.backend.Dto.RewardTeamDto;
import com.spring.backend.Entity.Employee;
import com.spring.backend.Entity.RewardTeam;
import com.spring.backend.Exception.RewardTeamException;
import com.spring.backend.Respository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service

public class RewardTeamMapper {
    private final EmployeeRepository employeeRepository;

    public RewardTeamMapper(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public RewardTeamDto toDTO(RewardTeam rewardTeam) {
        if (rewardTeam == null) {
            return null;
        }

        RewardTeamDto dto = new RewardTeamDto();
        dto.setId(rewardTeam.getId());
        dto.setEmployeeId(rewardTeam.getEmployee() != null ? rewardTeam.getEmployee().getId() : null);
        dto.setName(rewardTeam.getName());
        dto.setAmount(rewardTeam.getAmount());

        return dto;
    }

    // Convert RewardTeamDTO to RewardTeam entity
    public RewardTeam toEntity(RewardTeamDto rewardTeamDTO) {
        if (rewardTeamDTO == null) {
            return null;
        }
        Employee employee=employeeRepository.findById(rewardTeamDTO.getEmployeeId()).orElseThrow(()->new RewardTeamException("Employee Id"));
        RewardTeam rewardTeam = new RewardTeam();
        rewardTeam.setId(rewardTeamDTO.getId());
        rewardTeam.setEmployee(employee);
        rewardTeam.setName(rewardTeamDTO.getName());
        rewardTeam.setAmount(rewardTeamDTO.getAmount());

        return rewardTeam;
    }
}
