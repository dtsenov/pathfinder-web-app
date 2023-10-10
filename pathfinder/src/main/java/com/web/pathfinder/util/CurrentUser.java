package com.web.pathfinder.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component("currentUser")
@SessionScope
public class CurrentUser {

    private String username;
    private String fullName;
    private Integer age;
    private String email;
    private boolean isLogged;

    public CurrentUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    //    public String getFullName() {
//        StringBuilder builder = new StringBuilder();
//
//        if (firstName != null) {
//            builder.append(firstName);
//        }
//
//        if (lastName != null) {
//            if (!builder.isEmpty()) {
//                builder.append(" ");
//            }
//            builder.append(lastName);
//        }
//        return builder.toString().trim();
//    }
}
