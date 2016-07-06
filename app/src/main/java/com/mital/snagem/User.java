package com.mital.snagem;

/**
 * Created by mital on 4/21/16.
 */
public class User {

    private int id;
    private String name;
    private String gender;
    private String school;
    private String classification;
    private String email;
    private String password;
    private String[] tags;
    private String team;
    private int points;

    public User(int id, String name, String gender, String school, String classification, String email, String password){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.school = school;
        this.classification = classification;
        this.email = email;
        this.password = password;
        tags = new String[13];

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
