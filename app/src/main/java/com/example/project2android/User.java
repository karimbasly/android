package com.example.project2android;

public class User {
    String name,email;
    int score;
    public User(){

    }
    public User(String name, String email,int score) {
        this.name = name;
        this.email = email;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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
