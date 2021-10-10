package com.example.pathfinder.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity{

    private Boolean approved;
    private String textContent;
    private LocalDateTime created;
    private Route route;
    private User author;

    public Comment() {
    }

    @Column(nullable = false)
    public Boolean getApproved() {
        return approved;
    }
    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    @Column(columnDefinition = "TEXT")
    public String getTextContent() {
        return textContent;
    }
    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    @Column(name = "created", nullable = false)
    public LocalDateTime getCreated() {
        return created;
    }
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @ManyToOne
    public Route getRoute() {
        return route;
    }
    public void setRoute(Route route) {
        this.route = route;
    }

    @ManyToOne
    public User getAuthor() {
        return author;
    }
    public void setAuthor(User author) {
        this.author = author;
    }
}
