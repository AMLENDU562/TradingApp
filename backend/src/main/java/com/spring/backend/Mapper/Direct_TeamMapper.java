package com.spring.backend.Mapper;

import com.spring.backend.Dto.Direct_TeamDto;
import com.spring.backend.Dto.EmployeeDto;
import com.spring.backend.Entity.Direct_Team;
import com.spring.backend.Entity.Employee;
import com.spring.backend.Respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Direct_TeamMapper {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public Direct_TeamMapper(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Direct_TeamDto toDto(Direct_Team directTeam) {
        Employee employee = directTeam.getEmployee();
        return new Direct_TeamDto(
                directTeam.getTeamId(),
                directTeam.getName(),
                directTeam.getAmount(),
                directTeam.getCommission(),
                employee != null ? employee.getId() : null // Use the correct method to convert Employee to EmployeeDto
        );
    }

    public Direct_Team toEntity(Direct_TeamDto dto) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(dto.getEmployeeId());
        // Handle the case where the employee might not be found
        Employee employee = optionalEmployee.orElseThrow(() -> new RuntimeException("Employee not found"));

        return new Direct_Team(
                dto.getTeamId(),
                dto.getName(),
                dto.getAmount(),
                dto.getCommission(),
                employee
        );
    }
}
