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
}

