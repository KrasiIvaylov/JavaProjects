package com.example.football.models.dto;

import com.example.football.models.entity.Position;
import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.time.LocalDate;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerSeedDto {
    @XmlElement(name = "first-name")
    private String firstName;
    @XmlElement(name = "last-name")
    private String lastName;
    @XmlElement(name = "email")
    private String email;
    @XmlElement(name = "birth-date")
    private Date birthDate;
    @XmlElement
    private Position position;
    @XmlElement
    private Stat stat;
    @XmlElement
    private Team team;
    @XmlElement
    private Town town;



    @Length(min = 2)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    @Length(min = 2)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Email()
    public String getEmail() {
        return email;
    }
    public void getEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }

    public Stat getStat() {
        return stat;
    }
    public void setStat(Stat stat) {
        this.stat = stat;
    }

    public Team getTeam() {
        return team;
    }
    public void setTeam(Team team) {
        this.team = team;
    }

    public Town getTown() {
        return town;
    }
    public void setTown(Town town) {
        this.town = town;
    }
}
