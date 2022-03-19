package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.entity.enums.CategoryNamesEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    private CategoryNamesEnum name;
    private String description;

    public Category() {
    }

    @Column(columnDefinition = "TEXT")
    public CategoryNamesEnum getName() {
        return name;
    }
    public void setName(CategoryNamesEnum name) {
        this.name = name;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
