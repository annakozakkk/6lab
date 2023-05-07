package ua.lviv.iot.algo.part1.ProjectorLab.model;


import jakarta.persistence.Entity;

import jakarta.persistence.Id;


@Entity
public class Bicycle {
    private String brand;
    private String type;
    @Id
    private Integer ID;

    public Bicycle() {
    }

    public Bicycle(String brand, String type) {
        this.brand = brand;
        this.type = type;

    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getID() {
        return ID;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }
}

