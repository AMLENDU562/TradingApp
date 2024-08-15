package com.spring.backend.Respository;

import com.spring.backend.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    Boolean existsBySponsorIdAndPassword(String sponsorId,String password);
    Employee existsBySponsorId(String sponsorId);

}
