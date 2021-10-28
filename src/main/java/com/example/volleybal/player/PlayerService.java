package com.example.volleybal.player;

import com.example.volleybal.dto.PlayerDto;
import com.example.volleybal.team.Team;
import com.example.volleybal.team.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

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

    public Player createPlayerFromData(PlayerDto playerDto) {
        Player player = new Player();
        player.setFirstName(playerDto.getFirstName());
        player.setLastName(playerDto.getLastName());
        player.setPosition(playerDto.getPosition());
        player.setLength(playerDto.getLength());
        player.setTeamName(playerDto.getTeamName());
        return player;
    }

    public Player addNewPlayer(PlayerDto player) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        Player player1 = createPlayerFromData(player);
        if (player.getLength() == null) {
            return player1;
        } else if (player.getLength() > 125 && player.getLength() < 225) {
            LocalDate localDate = LocalDate.parse(player.getDateOfBirth(), formatter);
            player1.setDateOfBirth(localDate);
            Team team = teamRepository.findByTeamName(player.getTeamName());
            player1.setTeam(team);
            return playerRepository.save(player1);
        }
        ;
        return player1;
    }

    public void deletePlayer(Long playerId) {
        boolean exists = playerRepository.existsById(playerId);
        if (!exists) {
            throw new IllegalStateException("player with id " + playerId + " does not exist");
        }
        playerRepository.deleteById(playerId);
    }

    public Player updatePlayer(PlayerDto passedPlayer) {
        Optional<Player> optionalPlayer = playerRepository.findById(passedPlayer.getId());
        Player existingPlayer = new Player();
        if (optionalPlayer.isPresent()) {
            existingPlayer = optionalPlayer.get();
            existingPlayer.setFirstName(passedPlayer.getFirstName());
            existingPlayer.setLastName(passedPlayer.getLastName());
            existingPlayer.setDateOfBirth(LocalDate.parse(passedPlayer.getDateOfBirth()));
            existingPlayer.setPosition(passedPlayer.getPosition());
            existingPlayer.setLength(passedPlayer.getLength());
            existingPlayer.setTeamName(passedPlayer.getTeamName());
            playerRepository.save(existingPlayer);
        }
        return existingPlayer;
    }
}

