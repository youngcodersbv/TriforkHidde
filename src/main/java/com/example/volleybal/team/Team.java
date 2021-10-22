package com.example.volleybal.team;

import com.example.volleybal.player.Player;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "team", schema = "public")
public class Team {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Player> players = new HashSet<>();

    @Column
    private String teamName;

    public Team() {
    }

/*    public Team(Long id, String teamName) {
        this.id = id;
        this.teamName = teamName;
    }*/

    public Team(Set<Player> players, String teamName) {
        this.players = players;
        this.teamName = teamName;
    }

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id + '\'' +
                "players=" + players +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}
