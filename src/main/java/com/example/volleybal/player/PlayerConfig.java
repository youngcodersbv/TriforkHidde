package com.example.volleybal.player;

import com.example.volleybal.team.Team;
import com.example.volleybal.team.TeamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class PlayerConfig {

        @Bean
        CommandLineRunner commandLineRunnerPlayer(PlayerRepository playerRepository, TeamRepository teamRepository) {
            return args -> {
                if(playerRepository.findAll().isEmpty()) {


                    Player hidde = new Player("Hidde", "Uittenbosch", "passer-loper", 1.92, 31, LocalDate.of(1989, 12,10), "Taurus");
                    playerRepository.saveAll(List.of(hidde));
                    Team byTeamName = teamRepository.findByTeamName(hidde.getTeamName());
                    byTeamName.getPlayers().add(hidde);
                }
            };
        }
}

