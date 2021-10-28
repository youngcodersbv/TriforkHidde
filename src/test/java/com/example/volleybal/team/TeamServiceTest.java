package com.example.volleybal.team;

import com.example.volleybal.dto.PlayerDto;
import com.example.volleybal.player.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.volleybal.testutils.ObjectInstallUtil.createPlayerDto;
import static com.example.volleybal.testutils.ObjectInstallUtil.createTeam;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TeamServiceTest {

    @Mock
    private TeamRepository teamRepository;
    @Mock
    private TeamService teamService;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        teamService = new TeamService(teamRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllTeams(){
        List<Team> teams = new ArrayList<>();
        teams.add(createTeam());

        when(teamRepository.findAll()).thenReturn(teams);
        List<Team> fetchedTeam = teamService.getTeams();

        assertThat(fetchedTeam.get(0)).isSameAs(teams.get(0));
        verify(teamRepository, times(1)).findAll();
    }

    @Test
    void canAddTeam(){
        Team team = createTeam();
        when(teamRepository.save(ArgumentMatchers.any(Team.class))).thenReturn(team);
        Team result = teamService.addNewTeam(team);
        assertThat(result.getTeamName()).isSameAs(team.getTeamName());
        verify(teamRepository, times(1)).save(ArgumentMatchers.any(Team.class));

    }

    @Test
    void canUpdateTeam(){
        Team teamUpdate = createTeam();
        Team result = new Team("Draisma Dynamo");

        when(teamRepository.findById(ArgumentMatchers.any(Long.class))).thenReturn(Optional.of(teamUpdate));
        result = teamService.updateTeam(teamUpdate);

        assertThat(result.getTeamName()).isSameAs(teamUpdate.getTeamName());
        verify(teamRepository,times(1)).save(ArgumentMatchers.any(Team.class));


    }

    @Test
    void canDeleteTeam(){
        when(teamRepository.existsById(ArgumentMatchers.any(Long.class))).thenReturn(true);
        teamService.deleteTeam(1L);
        verify(teamRepository,times(1)).deleteById(ArgumentMatchers.any(Long.class));
    }


}
