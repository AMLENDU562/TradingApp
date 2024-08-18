package com.spring.backend.Controller;

import com.spring.backend.Dto.Direct_TeamDto;
import com.spring.backend.Service.DirectTeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/directTeam")
public class DirectTeamController {

    private final DirectTeamService directTeamService;

    @GetMapping("/all/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Direct_TeamDto>> getAll(@PathVariable Integer id) {
        List<Direct_TeamDto> directTeamDtos = directTeamService.getAll(id);
        return new ResponseEntity<>(directTeamDtos, HttpStatus.OK);
    }

    @GetMapping("/{teamId}")
    public ResponseEntity<Direct_TeamDto> getById(@PathVariable Integer teamId) {
        Direct_TeamDto directTeamDto = directTeamService.getByID(teamId);
        if (directTeamDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(directTeamDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{teamId}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer teamId) {
        boolean deleted = directTeamService.delete(teamId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public ResponseEntity<Direct_TeamDto> postDirectTeam(@RequestBody Direct_TeamDto directTeamDto) {
        if (directTeamDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Direct_TeamDto createdDirectTeamDto = directTeamService.post(directTeamDto);
        return new ResponseEntity<>(createdDirectTeamDto, HttpStatus.CREATED);
    }
}
