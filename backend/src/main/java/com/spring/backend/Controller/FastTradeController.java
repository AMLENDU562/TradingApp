package com.spring.backend.Controller;


import com.spring.backend.Dto.FastTradeTeamDto;
import com.spring.backend.Service.FastTradeService;
import com.spring.backend.Service.RewardTeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/FastTradeTeam")


public class FastTradeController {
    private final FastTradeService fastTradeService;

    @GetMapping("/all/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<FastTradeTeamDto>> getAll(@PathVariable Integer id) {
        List<FastTradeTeamDto> fastTradeIncomeDtos = fastTradeService.getAll(id);
        return new ResponseEntity<>(fastTradeIncomeDtos, HttpStatus.OK);
    }

    @GetMapping("/{teamId}")
    public ResponseEntity<FastTradeTeamDto> getById(@PathVariable Integer teamId) {
        FastTradeTeamDto fastTradeIncomeDto = fastTradeService.getByID(teamId);
        if (fastTradeIncomeDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(fastTradeIncomeDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{teamId}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer teamId) {
        boolean deleted = fastTradeService.delete(teamId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public ResponseEntity<FastTradeTeamDto> postDirectTeam(@RequestBody FastTradeTeamDto fastTradeTeamDto) {
        if (fastTradeTeamDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        FastTradeTeamDto createdFastTradeIncomeDto = fastTradeService.post(fastTradeTeamDto);
        return new ResponseEntity<>(createdFastTradeIncomeDto, HttpStatus.CREATED);
    }
}
