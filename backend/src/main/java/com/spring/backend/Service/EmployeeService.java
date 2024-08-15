package com.spring.backend.Service;

import com.spring.backend.Entity.Employee;
import com.spring.backend.Dto.EmployeeDto;
import com.spring.backend.PassingData.login;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    EmployeeDto postEmployee(Employee Employee);
    boolean existEmployee(login employeeLogin);
}
