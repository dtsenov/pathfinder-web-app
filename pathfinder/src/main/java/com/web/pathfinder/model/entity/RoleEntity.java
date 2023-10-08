package com.web.pathfinder.model.entity;

import com.web.pathfinder.model.enums.RoleEnum;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "role_id")
    private RoleEnum role;

    @OneToMany
    @Column(name = "user_entity_id")
    private Set<UserEntity> users;

    public RoleEntity() {
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }
}
