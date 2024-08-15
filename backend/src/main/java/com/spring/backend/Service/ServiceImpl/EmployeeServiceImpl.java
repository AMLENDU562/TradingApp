package com.spring.backend.Service.ServiceImpl;


import com.spring.backend.Entity.Employee;
import com.spring.backend.Dto.EmployeeDto;
import com.spring.backend.PassingData.login;
import com.spring.backend.Mapper.EmployeeMapper;
import com.spring.backend.Respository.EmployeeRepository;
import com.spring.backend.Service.DirectTeamService;
import com.spring.backend.Service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service


public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    DirectTeamService directTeamService;

    public EmployeeDto postEmployee(Employee Employee)
    {
        employeeRepository.save(Employee);
        return employeeMapper.EmployeeDtoTo(Employee);
    }

    @Override
    public boolean existEmployee(login employeeLogin) {

        boolean exist=employeeRepository.existsBySponsorIdAndPassword(employeeLogin.getSponsorId(),employeeLogin.getPassword());

        if(exist)
        {
            Integer EmployeeId=employeeRepository.existsBySponsorId(employeeLogin.getSponsorId()).getId();
            directTeamService.getAll(EmployeeId);
        }

        return exist;
    }
}
