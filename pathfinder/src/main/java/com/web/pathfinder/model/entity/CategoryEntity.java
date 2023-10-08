package com.web.pathfinder.model.entity;

import com.web.pathfinder.model.enums.CategoryEnum;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private CategoryEnum name;

    @OneToMany
    private Set<RouteEntity> routes;

    public CategoryEntity() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryEnum getName() {
        return name;
    }

    public void setName(CategoryEnum name) {
        this.name = name;
    }

    public Set<RouteEntity> getRoutes() {
        return routes;
    }

    public void setRoutes(Set<RouteEntity> routes) {
        this.routes = routes;
    }
}
