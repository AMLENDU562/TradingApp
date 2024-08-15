package com.spring.backend.Service.ServiceImpl;

import com.spring.backend.Dto.Direct_TeamDto;
import com.spring.backend.Entity.Direct_Team;
import com.spring.backend.Mapper.Direct_TeamMapper;
import com.spring.backend.Respository.DirectTeamRespository;
import com.spring.backend.Service.DirectTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DirectTeamServiceImpl implements DirectTeamService {

    private final Direct_TeamMapper directTeamMapper;
    private final DirectTeamRespository directTeamRespository;

    @Autowired
    public DirectTeamServiceImpl(Direct_TeamMapper directTeamMapper, DirectTeamRespository directTeamRespository) {
        this.directTeamMapper = directTeamMapper;
        this.directTeamRespository = directTeamRespository;
    }

    @Override
    public List<Direct_TeamDto> getAll(Integer employeeId) {
        List<Direct_TeamDto> direct_Teams = new ArrayList<>();
        for (Direct_Team i : directTeamRespository.findByEmployeeId(employeeId)) {
            Direct_TeamDto directTeamDto = directTeamMapper.toDto(i);
            direct_Teams.add(directTeamDto);
        }
        return direct_Teams;
    }

    @Override
    public Direct_TeamDto getByID(Integer Team_Id) {
        return directTeamMapper.toDto(directTeamRespository.getByTeamId(Team_Id));
    }

    @Override
    public Boolean delete(Integer Team_id) {
        if (directTeamRespository.existsByTeamId(Team_id)) {
            directTeamRespository.deleteById(Team_id);
            return true;
        }
        return false;
    }

    @Override
    public Direct_TeamDto post(Direct_TeamDto directTeamDto) {
        Direct_Team directTeam = directTeamMapper.toEntity(directTeamDto);
        return directTeamMapper.toDto(directTeamRespository.save(directTeam));
    }
}
