package com.example.volleybal.testutils;

import com.example.volleybal.dto.PlayerDto;
import com.example.volleybal.player.Player;
import com.example.volleybal.team.Team;

import java.time.LocalDate;
import java.util.Set;

public class ObjectInstallUtil {

    public static Player createPlayer(Integer length){

        Player player = new Player();
        player.setFirstName("das");
        player.setLastName("das");
        player.setLength(length);
        player.setTeamName("Taurus");
        player.setDateOfBirth(LocalDate.of(2000,1,1));
        player.setPosition("Libero");
        return player;

    }

    public static PlayerDto createPlayerDto(Integer length){

        PlayerDto player = new PlayerDto();
        player.setFirstName("das");
        player.setLastName("das");
        player.setLength(length);
        player.setTeamName("Taurus");
        player.setDateOfBirth("1900-01-01");
        player.setPosition("Libero");
        return player;

    }

    public static Team createTeam(Player players){
        Team team = new Team();
        team.setTeamName("Taurus");
        team.setPlayers(players);
        return team;
    }

}
