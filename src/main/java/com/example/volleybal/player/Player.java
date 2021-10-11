package com.example.volleybal.player;

import com.example.volleybal.team.Team;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

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
    private Double length;
    @Transient
    private Integer age;
    private LocalDate dateOfBirth;
    private String teamName;

    @ManyToOne()
    @JoinColumn(name = "team_id")
    private Team team;



    public Player() {
    }

    public Player(String firstName, String lastName, String position, Double length, LocalDate dateOfBirth, String teamName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.length = length;
        this.dateOfBirth = dateOfBirth;
        this.teamName = teamName;
    }

    public Player(String firstName, String lastName, String position, Double length, Integer age, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.length = length;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
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

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Integer getAge() {
        return Period.between(dateOfBirth,LocalDate.now()).getYears();
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
                '}';
    }
}
