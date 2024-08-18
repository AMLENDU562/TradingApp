package com.spring.backend.Respository;

import com.spring.backend.Entity.FastTradeTeam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FastTradeRepository extends JpaRepository<FastTradeTeam,Integer> {
    List<FastTradeTeam> findByEmployeeId(Integer employeeId);

}
