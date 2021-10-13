package com.example.volleybal.team;

import com.example.volleybal.player.Player;
import com.example.volleybal.player.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class TeamConfig {

    @Bean
    CommandLineRunner commandLineRunner(TeamRepository teamRepository, PlayerRepository playerRepository) {
        return args -> {
            if(teamRepository.findAll().isEmpty() && playerRepository.findAll().isEmpty()) {
                Team dynamo = new Team("Draisma Dynamo");
                Team lycurgus = new Team("Amysoft Lycurgus");
                Team taurus = new Team("Taurus");
                Team vcn = new Team("ComputerPlan VCN");
                Team vocasa = new Team("VoCASA");
                Team sss = new Team("Simplex SSS");
                Team orion = new Team("Active Living Orion");
                Team slie = new Team("Sliedrecht Sport");
                Team numidia = new Team("Numidia TopVolleybal Limbug");
                Team tt = new Team("Talentteam Papendal");
                Team zvh = new Team("RECO ZVH");
                teamRepository.saveAll(List.of(dynamo, lycurgus, taurus, vcn,vocasa,sss,orion,slie,tt,zvh,numidia));
            }
        };
    }
}
