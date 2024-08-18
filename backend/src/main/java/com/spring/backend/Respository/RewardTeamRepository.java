package com.spring.backend.Respository;

import com.spring.backend.Entity.RewardTeam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RewardTeamRepository extends JpaRepository<RewardTeam,Integer> {
    List<RewardTeam> findByEmployeeId(Integer employeeId);
}
