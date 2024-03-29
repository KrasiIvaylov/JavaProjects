package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.entity.enums.LevelEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "routes")
public class Route  extends BaseEntity{

    private String gpxCoordinates;
    private LevelEnum level;
    private String name;
    private User author;
    private String videoUrl;
    private String description;
    private Set<Category> categories;

    public Route() {
    }

    @Column(columnDefinition = "LONGTEXT")
    public String getGpxCoordinates() {
        return gpxCoordinates;
    }
    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    @Enumerated(EnumType.STRING)
    public LevelEnum getLevel() {
        return level;
    }
    public void setLevel(LevelEnum level) {
        this.level = level;
    }

    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    public User getAuthor() {
        return author;
    }
    public void setAuthor(User author) {
        this.author = author;
    }

    @Column(name = "video_url")
    public String getVideoUrl() {
        return videoUrl;
    }
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToMany
    public Set<Category> getCategories() {
        return categories;
    }
    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
