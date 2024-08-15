package com.spring.backend.Controller;

import com.spring.backend.Entity.Employee;
import com.spring.backend.Dto.EmployeeDto;
import com.spring.backend.PassingData.login;
import com.spring.backend.Mapper.EmployeeMapper;
import com.spring.backend.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authentication")
@AllArgsConstructor
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeService employeeService;

    // CORS configuration applied to this method for signup
    @PostMapping("/signup")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<EmployeeDto> postEmployee(@RequestBody EmployeeDto employeedto) {
        Employee Employee = employeeMapper.EmployeeTo(employeedto);
        EmployeeDto newEmployeeDto = employeeService.postEmployee(Employee);
        return new ResponseEntity<>(newEmployeeDto, HttpStatus.CREATED);
    }

    // CORS configuration applied to this method for login
    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Boolean> existEmployee(@RequestBody login employeeLogin) {
        boolean exists = employeeService.existEmployee(employeeLogin);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }
}
