package com.spring.backend.Service;

import com.spring.backend.Dto.Direct_TeamDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DirectTeamService {
    List<Direct_TeamDto> getAll(Integer id);
    boolean delete(Integer Team_id);
    Direct_TeamDto getByID(Integer Team_id);
    Direct_TeamDto post(Direct_TeamDto directTeamDto);
}
