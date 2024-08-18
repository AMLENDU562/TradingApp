package com.spring.backend.Service.ServiceImpl;

import com.spring.backend.Dto.RewardTeamDto;
import com.spring.backend.Entity.FastTradeTeam;
import com.spring.backend.Entity.RewardTeam;
import com.spring.backend.Exception.FastTradeException;
import com.spring.backend.Mapper.RewardTeamMapper;
import com.spring.backend.Respository.RewardTeamRepository;
import com.spring.backend.Service.RewardTeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RewardTeamImpl implements RewardTeamService {
    private final RewardTeamRepository rewardTeamRepository;
    private final RewardTeamMapper rewardTeamMapper;
    @Override
    public List<RewardTeamDto> getAll(Integer id) {
        return rewardTeamRepository.findByEmployeeId(id).stream()
                .map(rewardTeamMapper::toDTO) // Use method reference
                .collect(Collectors.toList());
    }

    @Override
    public RewardTeamDto getByID(Integer id) {
        RewardTeam rewardTeam = rewardTeamRepository.findById(id)
                .orElseThrow(() -> new FastTradeException("Fast Trade Id " + id + " cannot be found"));
        return rewardTeamMapper.toDTO(rewardTeam);
    }

    @Override
    public RewardTeamDto post(RewardTeamDto rewardTeamDto) {
        RewardTeam rewardTeam = rewardTeamMapper.toEntity(rewardTeamDto);
        RewardTeam savedFastTradeTeam = rewardTeamRepository.save(rewardTeam);
        return rewardTeamMapper.toDTO(savedFastTradeTeam);
    }

    @Override
    public boolean delete(Integer id) {
        if (rewardTeamRepository.existsById(id)) {
            rewardTeamRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
