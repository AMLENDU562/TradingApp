package com.spring.backend.Mapper;

import com.spring.backend.Entity.Employee;
import com.spring.backend.Dto.EmployeeDto;
import org.springframework.stereotype.Service;

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
}
