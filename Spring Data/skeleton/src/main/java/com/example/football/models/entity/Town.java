package com.example.football.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity{
    private String name;
    private Integer population;
    private String travelGuide;

    public Town() {
    }

    @Column()
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column()
    public Integer getPopulation() {
        return population;
    }
    public void setPopulation(Integer population) {
        this.population = population;
    }

    @Column(name = "travel_guide", columnDefinition = "TEXT")
    public String getTravelGuide() {
        return travelGuide;
    }
    public void setTravelGuide(String travelGuide) {
        this.travelGuide = travelGuide;
    }
}
