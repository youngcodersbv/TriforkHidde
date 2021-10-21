package com.example.volleybal.player;

import com.example.volleybal.dto.PlayerDto;
import com.example.volleybal.team.Team;
import com.example.volleybal.team.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository,
                         TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public Player addNewPlayer(PlayerDto player) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        Player player1 = player.createPlayerFromData();
        if (player.getLength() == null){
            return player1;
        }
        else if (player.getLength() > 125 && player.getLength() < 225) {
            LocalDate localDate = LocalDate.parse(player.getDateOfBirth(), formatter);
            player1.setDateOfBirth(localDate);
            Team team = teamRepository.findByTeamName(player.getTeamName());
            player1.setTeam(team);
            return playerRepository.save(player1);
        };
        return player1;
    }

    public void deletePlayer(Long playerId) {
        boolean exists = playerRepository.existsById(playerId);
        if (!exists) {
            throw new IllegalStateException("player with id " + playerId + " does not exist");
        }
        playerRepository.deleteById(playerId);
    }

}

/*  @Transactional
    public void updateTeam(Long teamId, String teamName){
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new IllegalStateException("team with id " + teamId + " does not exist"));

        if(teamName!= null && teamName.length()>0 && !Objects.equals(team.getTeamName(), teamName)){
            team.setTeamName(teamName);
        }
    }
}*/
