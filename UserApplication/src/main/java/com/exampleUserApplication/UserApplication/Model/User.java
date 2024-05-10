package com.exampleUserApplication.UserApplication.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "user", schema = "public")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column(updatable = true, nullable = false)
    private String name;
    private String userName;
    private String email;
    public User() {
    }

    public User(Long id, String name, String userName, String email) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
