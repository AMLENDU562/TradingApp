package com.spring.backend.Mapper;

import com.spring.backend.Entity.Employee;
import com.spring.backend.Entity.LevelTeam;
import com.spring.backend.Dto.LevelTeamDto;
import com.spring.backend.Exception.LevelTeamException;
import com.spring.backend.Respository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class LevelTeamMapper {

    private final EmployeeRepository employeeRepository;

    public  LevelTeamDto toDTO(LevelTeam levelTeam) {
        LevelTeamDto dto = new LevelTeamDto();
        dto.setId(levelTeam.getId());
        dto.setSponsorId(levelTeam.getSponsorId());
        dto.setName(levelTeam.getName());
        dto.setAmount(levelTeam.getAmount());
        dto.setLevelTradeIncome(levelTeam.getLevelTradeIncome());
        dto.setLevel(levelTeam.getLevel());
        if (levelTeam.getEmployee() != null) {
            dto.setEmployeeId(levelTeam.getEmployee().getId());
        }
        return dto;
    }

    public  LevelTeam toEntity(LevelTeamDto dto) {
        LevelTeam levelTeam = new LevelTeam();
        levelTeam.setId(dto.getId());
        levelTeam.setSponsorId(dto.getSponsorId());
        levelTeam.setName(dto.getName());
        levelTeam.setAmount(dto.getAmount());
        levelTeam.setLevelTradeIncome(dto.getLevelTradeIncome());
        levelTeam.setLevel(dto.getLevel());
        levelTeam.setEmployee(employeeRepository.findById(dto.getEmployeeId()).orElseThrow(()->new LevelTeamException("id cannot be found")));
        // Assuming you have a method to get the Employee by ID

        return levelTeam;
    }
}
