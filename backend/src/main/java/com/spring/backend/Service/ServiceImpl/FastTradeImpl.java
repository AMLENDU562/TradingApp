package com.spring.backend.Service.ServiceImpl;

import com.spring.backend.Dto.FastTradeTeamDto;
import com.spring.backend.Entity.FastTradeTeam;
import com.spring.backend.Exception.FastTradeException;
import com.spring.backend.Mapper.FastTradeMapper;
import com.spring.backend.Respository.FastTradeRepository;
import com.spring.backend.Service.FastTradeService;
import com.spring.backend.Service.RewardTeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FastTradeImpl implements FastTradeService {

    private final FastTradeRepository fastTradeRepository;
    private final FastTradeMapper fastTradeMapper;

    @Override
    public FastTradeTeamDto getByID(Integer id) {
        FastTradeTeam fastTradeTeam = fastTradeRepository.findById(id)
                .orElseThrow(() -> new FastTradeException("Fast Trade Id " + id + " cannot be found"));
        return fastTradeMapper.toDTO(fastTradeTeam);
    }

    @Override
    public boolean delete(Integer id) {
        if (fastTradeRepository.existsById(id)) {
            fastTradeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<FastTradeTeamDto> getAll(Integer id) {
        return fastTradeRepository.findByEmployeeId(id).stream()
                .map(fastTradeMapper::toDTO) // Use method reference
                .collect(Collectors.toList());
    }

    @Override
    public FastTradeTeamDto post(FastTradeTeamDto fastTradeTeamDto) {
        FastTradeTeam fastTradeTeam = fastTradeMapper.toEntity(fastTradeTeamDto);
        FastTradeTeam savedFastTradeTeam = fastTradeRepository.save(fastTradeTeam);
        return fastTradeMapper.toDTO(savedFastTradeTeam);
    }
}
