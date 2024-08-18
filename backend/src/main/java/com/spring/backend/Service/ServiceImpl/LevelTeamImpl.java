package com.spring.backend.Service.ServiceImpl;

import com.spring.backend.Dto.LevelTeamDto;
import com.spring.backend.Entity.LevelTeam;
import com.spring.backend.Exception.LevelTeamException;
import com.spring.backend.Mapper.LevelTeamMapper;
import com.spring.backend.Respository.LevelTeamRepository;
import com.spring.backend.Service.LevelTeamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class LevelTeamImpl implements LevelTeamService {
    private final LevelTeamRepository levelTeamRepository;
    private final LevelTeamMapper levelTeamMapper;
    @Override
    public LevelTeamDto getByID(Integer id) {
        LevelTeamDto levelTeamDto=levelTeamMapper.toDTO(levelTeamRepository.findById(id).orElseThrow(()->new LevelTeamException("id cannot be found")));
        return levelTeamDto;
    }

    @Override
    public List<LevelTeamDto> getAll(Integer id, Integer level) {
        List<LevelTeamDto>levelTeamDtos=levelTeamRepository.getByEmployeeIdAndLevel(id,level).stream()
                .map(levelTeamMapper::toDTO).toList();
        return levelTeamDtos;
    }

    @Override
    public LevelTeamDto post(LevelTeamDto levelTeamDto) {
        LevelTeam levelTeam=levelTeamMapper.toEntity(levelTeamDto);
        return levelTeamMapper.toDTO(levelTeamRepository.save(levelTeam));
    }

    @Override
    public boolean delete(Integer id) {

        if(levelTeamRepository.existsById(id))
        {
            levelTeamRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
