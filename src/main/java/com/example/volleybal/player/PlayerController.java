package com.example.volleybal.player;

import com.example.volleybal.player.Player;
import com.example.volleybal.player.PlayerService;
import com.example.volleybal.team.Team;
import com.example.volleybal.team.TeamRepository;
import com.example.volleybal.team.TeamService;
import lombok.RequiredArgsConstructor;
import org.hibernate.EntityMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path = "/api/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getPlayers() {
        return playerService.getPlayers();

    }

    public boolean checkTeam(Set<Player> players, String firstName){
        List<String> stringStream = players.stream().map(player -> player.getFirstName()).collect(Collectors.toList());
        return stringStream.contains(firstName);
    }

    @PostMapping
    public void createNewPlayer(@RequestBody Player player) {
        Team team = teamRepository.findByTeamName(player.getTeamName());
        if(!checkTeam(team.getPlayers(), player.getFirstName())){
            player.setTeam(team);
            team.getPlayers().add(player);
        }
        teamRepository.save(team);
    }

  @DeleteMapping(path = "{Id}")
    public void deleteTeam(@PathVariable("Id") Long teamId) {
        playerRepository.deleteById(teamId);
    }

/*    @PutMapping(path = "{teamId}")
    public void updateTeam(@PathVariable("teamId") Long teamId, @RequestParam(required = false) String teamName) {
        playerService.updateTeam(teamId, teamName);
    }
}*/

}
