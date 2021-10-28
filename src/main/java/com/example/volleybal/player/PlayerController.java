package com.example.volleybal.player;

import com.example.volleybal.dto.PlayerDto;
import com.example.volleybal.team.Team;
import com.example.volleybal.team.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/players")
public class PlayerController {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    PlayerService playerService;

    @Autowired
    PlayerRepository playerRepository;

    @GetMapping()
    public String index(Model model) {
        Iterable iter = playerRepository.findAll();
        model.addAttribute("players", iter);
        return "players";
    }

    @PostMapping()
    public String postIndex(@ModelAttribute PlayerDto player) {
        System.out.println(player.toString());
        playerService.addNewPlayer(player);
        return "redirect:/players";
    }

    @GetMapping("/{id}")
    public String getPlayerById(@PathVariable("id") long id, Model model) {
        Optional<Player> optionsPlayer = playerRepository.findById(id);
        if (optionsPlayer.isPresent()) {
            model.addAttribute("players", optionsPlayer.get());
            return "specificPlayer";
        } else {

            return "redirect:/players";
        }

    }

    @PostMapping("/updatePlayer")
    public String updatePlayer(@ModelAttribute PlayerDto passedPlayer) {
        playerService.updatePlayer(passedPlayer);
        return String.format("redirect:/players/%s", passedPlayer.getId());
    }


    @GetMapping("/deletePlayer")
    public String deletePlayer(@RequestParam(name = "id") Long playerId) {
        playerService.deletePlayer(playerId);
        return "redirect:/players";
    }

}
/*    @GetMapping("/deletePlayer")
    public String deletePlayer(@RequestParam(name = "id") Long playerId) {
        boolean exists = playerRepository.existsById(playerId);
        if (!exists) {
            throw new IllegalStateException("player with id " + playerId + " does not exist");
        }
        playerRepository.deleteById(playerId);
        return "redirect:/players";


        Optional<Player> optionalPlayer = playerRepository.findById(passedPlayer.getId());
        if (optionalPlayer.isPresent()){
            Player existingPlayer = optionalPlayer.get();
            existingPlayer.setFirstName(passedPlayer.getFirstName());
            existingPlayer.setLastName(passedPlayer.getLastName());
            existingPlayer.setDateOfBirth(passedPlayer.getDateOfBirth());
            existingPlayer.setPosition(passedPlayer.getPosition());
            existingPlayer.setLength(passedPlayer.getLength());
            existingPlayer.setTeamName(passedPlayer.getTeamName());
            playerRepository.save(existingPlayer);
    }*/


