package com.spring.backend.Service;


import com.spring.backend.Dto.RewardTeamDto;

import java.util.List;

public interface RewardTeamService {
    List<RewardTeamDto> getAll(Integer id);

    boolean delete(Integer id);
    RewardTeamDto getByID(Integer id);
    RewardTeamDto post(RewardTeamDto fastTradeIncomeDto);
}
