package com.example.project2android;

public class User {
    String name,email;
    public User(){

    }
    public User(String name, String email) {
        this.name = name;
        this.email = email;
        //  this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}