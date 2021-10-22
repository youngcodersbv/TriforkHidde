package com.example.volleybal.player;

import com.example.volleybal.dto.PlayerDto;
import com.example.volleybal.team.TeamRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.example.volleybal.testutils.ObjectInstallUtil.createPlayer;
import static com.example.volleybal.testutils.ObjectInstallUtil.createPlayerDto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;
    @Mock
    private TeamRepository teamRepository;
    private PlayerService playerService;
    private AutoCloseable autoCloseable;


    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        playerService = new PlayerService(playerRepository, teamRepository);
    }
    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void canGetAllPlayers(){
        List<Player> players = new ArrayList<>();
        players.add(createPlayer(10));

        when(playerRepository.findAll()).thenReturn(players);
        List<Player> fetchedPlayers = playerService.getPlayers();

        assertThat(fetchedPlayers.get(0)).isSameAs(players.get(0));
        verify(playerRepository, times(1)).findAll();
    }

    @Test
    void canAddPlayer(){
        PlayerDto player = createPlayerDto(126);

        when(playerRepository.save(ArgumentMatchers.any(Player.class))).thenReturn(playerService.createPlayerFromData(player));

        Player result = playerService.addNewPlayer(player);
        assertThat(result.getFirstName()).isSameAs(player.getFirstName());
        verify(playerRepository, times(1)).save(ArgumentMatchers.any(Player.class));

    }

    @Test
    void canDeletePlayer(){
        when(playerRepository.existsById(ArgumentMatchers.any(Long.class))).thenReturn(true);
        playerService.deletePlayer(1l);
        verify(playerRepository, times(1)).deleteById(ArgumentMatchers.any(Long.class));

    }
}
