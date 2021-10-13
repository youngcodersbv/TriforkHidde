package com.example.volleybal.team;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(path = "/api/team")
//@XmlRootElement
public class TeamControllerJson {

    private TeamService teamService;

    public TeamControllerJson(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<Team> getTeams() {
        return teamService.getTeams();

    }

    @PostMapping
    public Team registerNewTeam(@RequestBody Team team) {
        return teamService.addNewTeam(team);
    }

    @DeleteMapping(path = "{teamId}")
    public void deleteTeam(@PathVariable("teamId") Long teamId) {
        teamService.deleteStudent(teamId);
    }

    @PutMapping(path = "{teamId}")
    public void updateTeam(@PathVariable("teamId") Long teamId, @RequestParam(required = false) String teamName) {
        teamService.updateTeam(teamId, teamName);
    }
}