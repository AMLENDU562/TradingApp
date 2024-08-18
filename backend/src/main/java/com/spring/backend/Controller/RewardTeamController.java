package com.spring.backend.Controller;


import com.spring.backend.Dto.RewardTeamDto;
import com.spring.backend.Service.FastTradeService;
import com.spring.backend.Service.RewardTeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/RewardTeam")


public class RewardTeamController {
    private final RewardTeamService rewardTeamService;

    @GetMapping("/all/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<RewardTeamDto>> getAll(@PathVariable Integer id) {
        List<RewardTeamDto> rewardTeamDtos =rewardTeamService.getAll(id) ;
        return new ResponseEntity<>(rewardTeamDtos, HttpStatus.OK);
    }

    @GetMapping("/{teamId}")
    public ResponseEntity<RewardTeamDto> getById(@PathVariable Integer teamId) {
        RewardTeamDto rewardTeamDto =rewardTeamService.getByID(teamId);
        if (rewardTeamDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rewardTeamDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{teamId}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer teamId) {
        boolean deleted = rewardTeamService.delete(teamId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public ResponseEntity<RewardTeamDto> postDirectTeam(@RequestBody RewardTeamDto rewardTeamDto) {
        if (rewardTeamDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        RewardTeamDto createdRewardTeamDto = rewardTeamService.post(rewardTeamDto);
        return new ResponseEntity<>(createdRewardTeamDto, HttpStatus.CREATED);
    }
}
