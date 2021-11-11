package com.example.lesson31.model;

import java.io.Serializable;

public class TaskModel implements Serializable {
    private String country, population;
    private int imageview, arms;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public int getImageview() {
        return imageview;
    }

    public void setImageview(int imageview) {
        this.imageview = imageview;
    }

    public int getArms() {
        return arms;
    }

    public void setArms(int arms) {
        this.arms = arms;
    }

    public TaskModel(String country, String population, int imageview, int arms) {
        this.country = country;
        this.population = population;
        this.imageview = imageview;
        this.arms = arms;
    }
}
