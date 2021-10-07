package com.example.volleybal.team;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TeamConfig {

    @Bean
    CommandLineRunner commandLineRunner(TeamRepository teamRepository) {
        return args -> {
            if(teamRepository.findAll().isEmpty()) {
                Team dynamo = new Team("Draisma Dynamo");
                Team lycurgus = new Team("Amysoft Lycurgus");

                teamRepository.saveAll(List.of(dynamo, lycurgus));
            }
        };
    }
}
