package com.spring.backend.Service.ServiceImpl;

import com.spring.backend.Dto.Direct_TeamDto;
import com.spring.backend.Entity.Direct_Team;
import com.spring.backend.Entity.Employee;
;
import com.spring.backend.Exception.DirectTeamException;
import com.spring.backend.Mapper.Direct_TeamMapper;
import com.spring.backend.Respository.DirectTeamRespository;
import com.spring.backend.Respository.EmployeeRepository;
import com.spring.backend.Service.DirectTeamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
@AllArgsConstructor
public class DirectTeamServiceImpl implements DirectTeamService {

    private final DirectTeamRespository directTeamRespository;
    private final EmployeeRepository employeeRepository;
    private final Direct_TeamMapper directTeamMapper;

    public List<Direct_TeamDto> getAll(Integer id) {
        // Implement your logic here
        List<Direct_TeamDto>dtos=new ArrayList<>();
        for (Direct_Team i : directTeamRespository.findByEmployeeId(id))
        {
            Direct_TeamDto dto=directTeamMapper.toDto(i);
            dtos.add(dto);

        }
        return dtos;

    }

    public Direct_TeamDto getByID(Integer teamId) {
        Direct_Team directTeam = directTeamRespository.findById(teamId)
                .orElseThrow(() -> new DirectTeamException("Team not found with id: " + teamId));
        return directTeamMapper.toDto(directTeam);
    }


    public boolean delete(Integer teamId) {
        if (directTeamRespository.existsById(teamId)) {
            directTeamRespository.deleteById(teamId);
            return true;
        }
        return false;
    }

    public Direct_TeamDto post(Direct_TeamDto dto) {
        Direct_Team directTeam;

        try {
            directTeam = directTeamMapper.toEntity(dto);
        } catch (Exception error) {
            // Log the error for debugging purposes
            System.err.println("Error converting DTO to entity: " + error.getMessage());
            // Handle the case where DTO conversion fails
            throw new DirectTeamException("Failed to convert DTO to entity: " + error.getMessage());
        }

        // Ensure the employee ID exists
        try {
            Employee employee = employeeRepository.findById(dto.getEmployeeId())
                    .orElseThrow(() -> new DirectTeamException("Employee with ID " + dto.getEmployeeId() + " not found"));
            directTeam.setEmployee(employee);
        } catch (Exception e) {
            // Handle the case where the employee ID does not exist
            throw new DirectTeamException("Failed to find employee: " + e.getMessage());
        }

        Direct_Team savedDirectTeam = directTeamRespository.save(directTeam);

        return directTeamMapper.toDto(savedDirectTeam);
    }



}
