package com.spring.backend.Respository;

import com.spring.backend.Entity.Direct_Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectTeamRespository extends JpaRepository<Direct_Team, Integer> {
    // Fetch records based on the employeeId field
    List<Direct_Team> findByEmployeeId(Integer employeeId);
}
