package com.example.volleybal.dto;

import com.example.volleybal.player.Player;
import lombok.Data;

import java.time.LocalDate;
@Data
public class PlayerDto {

    private String firstName;
    private String lastName;
    private String position;
    private Integer length;
    private String dateOfBirth;
    private String teamName;

    public Player createPlayerFromData() {
        Player player = new Player();
        player.setFirstName(firstName);
        player.setLastName(lastName);
        player.setPosition(position);
        player.setLength(length);
        player.setTeamName(teamName);
        return player;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
