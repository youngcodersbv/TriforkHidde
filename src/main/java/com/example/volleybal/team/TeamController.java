package com.example.volleybal.team;

import com.example.volleybal.dto.PlayerDto;
import com.example.volleybal.player.PlayerRepository;
import com.example.volleybal.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


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

}


