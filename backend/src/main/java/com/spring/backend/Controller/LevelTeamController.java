package com.spring.backend.Controller;

import com.spring.backend.Dto.LevelTeamDto;
import com.spring.backend.Service.LevelTeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/LevelTeam")
@CrossOrigin("http://localhost:3000") // Ensuring Cross-Origin is applied to the whole controller
public class LevelTeamController {

    private final LevelTeamService levelTeamService;

    @GetMapping("/all/{id}/{level}")
    public ResponseEntity<List<LevelTeamDto>> getAll(@PathVariable Integer id, @PathVariable Integer level) {
        List<LevelTeamDto> levelTeamDtos = levelTeamService.getAll(id, level);
        return new ResponseEntity<>(levelTeamDtos, HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<LevelTeamDto> post(@RequestBody LevelTeamDto levelTeamDto) {
        LevelTeamDto createdLevelTeamDto = levelTeamService.post(levelTeamDto);
        return new ResponseEntity<>(createdLevelTeamDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LevelTeamDto> getById(@PathVariable Integer id) {
        LevelTeamDto levelTeamDto = levelTeamService.getByID(id);
        return new ResponseEntity<>(levelTeamDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
        boolean deleted = levelTeamService.delete(id);
        return new ResponseEntity<>(deleted, HttpStatus.ACCEPTED);
    }
}
