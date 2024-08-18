package com.spring.backend.Respository;

import com.spring.backend.Entity.LevelTeam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LevelTeamRepository extends JpaRepository<LevelTeam,Integer> {

    List<LevelTeam> getByEmployeeIdAndLevel(Integer employeeId,Integer level);
}
