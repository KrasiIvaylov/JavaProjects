package com.example.pathfinder.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Messages extends BaseEntity{
    private LocalDateTime dateTime;
    private String textContent;
    private User author;
    private User recipient;

    public Messages() {
    }

    @Column(name = "date_time")
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Column(name = "text_content", columnDefinition = "TEXT", nullable = false)
    public String getTextContent() {
        return textContent;
    }
    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    @ManyToOne
    public User getAuthor() {
        return author;
    }
    public void setAuthor(User author) {
        this.author = author;
    }

    @ManyToOne
    public User getRecipient() {
        return recipient;
    }
    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }
}
