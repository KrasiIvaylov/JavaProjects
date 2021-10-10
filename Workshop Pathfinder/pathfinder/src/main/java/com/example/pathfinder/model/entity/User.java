package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.entity.enums.LevelEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User  extends BaseEntity{
    private String fullName;
    private String username;
    private String password;
    private String email;
    private Integer age;
    private LevelEnum level;
    private Set<Role> roles;

    public User() {
    }
    @Column(nullable = false)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    @Column(nullable = false, unique = true)
    public String getUsername() {
        return username;
    }
    public void setUsername(String fullName) {
        this.username = fullName;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "age")
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    @Enumerated(EnumType.STRING)
    public LevelEnum getLevel() {
        return level;
    }
    public void setLevel(LevelEnum level) {
        this.level = level;
    }

    @ManyToMany
    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
