package com.example.football.models.entity;

import org.apache.tomcat.jni.Local;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "players")
public class Player extends BaseEntity{
    private String firstName;
    private String lastName;
    private String email;
    private Date birthDate;
    private Position position;
    private Stat stat;
    private Team team;
    private Town town;

    public Player() {
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "birth_date", nullable = true)
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Column
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }

    @OneToOne
    public Stat getStat() {
        return stat;
    }
    public void setStat(Stat stat) {
        this.stat = stat;
    }

    @OneToOne
    public Team getTeam() {
        return team;
    }
    public void setTeam(Team team) {
        this.team = team;
    }

    @OneToOne
    public Town getTown() {
        return town;
    }
    public void setTown(Town town) {
        this.town = town;
    }
}
