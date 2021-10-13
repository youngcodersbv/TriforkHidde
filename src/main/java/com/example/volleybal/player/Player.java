package com.example.volleybal.player;

import com.example.volleybal.team.Team;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "player", schema = "public")
@JsonIgnoreProperties({"team"})
public class Player {


    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private Integer length;
    @Transient
    private Integer age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    private String teamName;

    @ManyToOne()
    @JoinColumn(name = "team_id")
    private Team team;


    public Player() {
    }

    public Player(String firstName, String lastName, String position, Integer length, LocalDate dateOfBirth, String teamName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.length = length;
        this.dateOfBirth = dateOfBirth;
        this.teamName = teamName;
        this.age = Period.between(dateOfBirth,LocalDate.now()).getYears();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getAge() {
        return dateOfBirth != null ? Period.between(dateOfBirth,LocalDate.now()).getYears() : 0;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Player{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", length=" + length +
                ", age=" + age +
                ", teamName='" + teamName + '\'' +
                ", dab='" + dateOfBirth + '\'' +
                '}';
    }
}
