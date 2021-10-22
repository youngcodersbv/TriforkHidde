package com.example.volleybal.team;

import com.example.volleybal.dto.PlayerDto;
import com.example.volleybal.player.Player;
import com.example.volleybal.player.PlayerRepository;
import com.example.volleybal.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping(path = "/teams")
public class TeamController {


    @Autowired
    TeamService teamService;

    @Autowired
    TeamRepository teamRepository;

    @GetMapping()
    public String index(Model model) {
        Iterable iter = teamRepository.findAll();
        model.addAttribute("teams", iter);
        return "teams";
    }

    @GetMapping("/{id}")
    public String getTeamById(@PathVariable("id") long id, Model model){
        Optional<Team> optionalTeam = teamRepository.findById(id);
        if (optionalTeam.isPresent()){
            model.addAttribute("teams", optionalTeam.get());
            return "specificTeam";
        }else{
            return "teams";
        }

    }

    @PostMapping("/updateTeam")
    public String updateTeam(@ModelAttribute Team passedTeam) {
        Optional<Team> optionalTeam = teamRepository.findById(passedTeam.getId());
        if(optionalTeam.isPresent()){
            Team existingTeam = optionalTeam.get();
            existingTeam.setTeamName(passedTeam.getTeamName());
            teamRepository.save(existingTeam);
        }
        return String.format("redirect:/teams/%s", passedTeam.getId());
    }


}


