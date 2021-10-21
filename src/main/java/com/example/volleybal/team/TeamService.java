package com.example.volleybal.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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


    @Transactional
    public void updateTeam(Long teamId, String teamName){
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new IllegalStateException("team with id " + teamId + " does not exist"));
        System.out.println(team);

        if(teamName!= null && teamName.length()>0 && !Objects.equals(team.getTeamName(), teamName)){
            team.setTeamName(teamName);
            System.out.println(team);
        }teamRepository.save(team);
    }
}
