package com.example.football.models.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity{
    private String name;
    private String stadiumName;
    private Integer fanBase;
    private String history;
    private Town towns;

    public Team() {
    }

    @Column()
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "stadium_name")
    public String getStadiumName() {
        return stadiumName;
    }
    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    @Column(name = "fan_base")
    public Integer getFanBase() {
        return fanBase;
    }
    public void setFanBase(Integer fanBase) {
        this.fanBase = fanBase;
    }

    @Column(columnDefinition = "TEXT")
    public String getHistory() {
        return history;
    }
    public void setHistory(String history) {
        this.history = history;
    }

    @OneToOne
    public Town getTowns() {
        return towns;
    }
    public void setTowns(Town towns) {
        this.towns = towns;
    }
}
