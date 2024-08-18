package com.spring.backend.Service;


import com.spring.backend.Dto.FastTradeTeamDto;

import java.util.List;

public interface FastTradeService {
    List<FastTradeTeamDto> getAll(Integer id);

    boolean delete(Integer id);
    FastTradeTeamDto getByID(Integer id);
    FastTradeTeamDto post(FastTradeTeamDto fastTradeIncomeDto);
}
