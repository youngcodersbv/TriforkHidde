package com.example.volleybal.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    public Team addNewTeam(Team team) {
        return teamRepository.save(team);
    }

    public void deleteTeam(Long teamId) {
        boolean exists = teamRepository.existsById(teamId);
        if (!exists) {
            throw new IllegalStateException("team with id " + teamId + " does not exist");
        }
        teamRepository.deleteById(teamId);
    }

    public Team updateTeam(Team team) {
        Optional<Team> optionalTeam = teamRepository.findById(team.getId());
        Team existingTeam = new Team();
        if (optionalTeam.isPresent()) {
            existingTeam = optionalTeam.get();
            existingTeam.setTeamName(team.getTeamName());
            teamRepository.save(existingTeam);
        }
        return existingTeam;
    }
}

