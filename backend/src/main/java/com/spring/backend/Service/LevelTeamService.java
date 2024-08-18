package com.spring.backend.Service;

import com.spring.backend.Dto.FastTradeTeamDto;
import com.spring.backend.Dto.LevelTeamDto;

import java.util.List;

public interface LevelTeamService {
    List<LevelTeamDto> getAll(Integer id,Integer level);

    boolean delete(Integer id);
    LevelTeamDto getByID(Integer id);
    LevelTeamDto post(LevelTeamDto levelTeamDto);
}
