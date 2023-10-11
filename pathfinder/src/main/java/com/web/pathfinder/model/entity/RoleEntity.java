package com.web.pathfinder.model.entity;

import com.web.pathfinder.model.enums.RoleEnum;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private RoleEnum name;

    public RoleEntity() {
    }

    public RoleEnum getName() {
        return name;
    }

    public void setName(RoleEnum name) {
        this.name = name;
    }
}
