package com.web.pathfinder.model.entity;

import com.web.pathfinder.model.enums.LevelEnum;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "routes")
public class RouteEntity extends BaseEntity {

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "gpx_coordinates", columnDefinition = "LONGTEXT")
    private String gpxCoordinates;

    @Enumerated(EnumType.STRING)
    private LevelEnum level;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "video_url")
    private String videoUrl;

    @ManyToOne
    private UserEntity author;

    @ManyToMany
    private Set<CategoryEntity> categories;

    public RouteEntity() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public void setLevel(LevelEnum level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public Set<CategoryEntity> getCategory() {
        return categories;
    }

    public void setCategory(Set<CategoryEntity> category) {
        this.categories = category;
    }
}
