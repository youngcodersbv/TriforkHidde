package com.example.volleybal.team;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

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


}
