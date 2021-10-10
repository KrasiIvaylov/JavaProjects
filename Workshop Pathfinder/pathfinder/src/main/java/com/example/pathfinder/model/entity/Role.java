package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.entity.enums.RoleNameEnum;
import com.fasterxml.jackson.databind.ser.Serializers;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    private RoleNameEnum role;

    public Role() {
    }

    @Enumerated(value = EnumType.STRING)
    public RoleNameEnum getRole() {
        return role;
    }

    public void setRole(RoleNameEnum name) {
        this.role = role;
    }
}
