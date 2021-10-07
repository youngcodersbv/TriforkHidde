package com.example.volleybal.player;

import com.example.volleybal.player.Player;
import com.example.volleybal.player.PlayerRepository;
import com.example.volleybal.team.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public Player addNewPlayer(Player player) {
        return playerRepository.save(player);
    }
}

/*    public void deleteStudent(Long teamId) {
        boolean exists = teamRepository.existsById(teamId);
        if (!exists) {
            throw new IllegalStateException("team with id " + teamId + " does not exist");
        }
        teamRepository.deleteById(teamId);
    }


    @Transactional
    public void updateTeam(Long teamId, String teamName){
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new IllegalStateException("team with id " + teamId + " does not exist"));

        if(teamName!= null && teamName.length()>0 && !Objects.equals(team.getTeamName(), teamName)){
            team.setTeamName(teamName);
        }
    }
}*/
