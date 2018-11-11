package com.nissan.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import com.nissan.entity.carparts.chassis.Chassis;
import com.nissan.entity.carparts.door.Door;
import com.nissan.entity.carparts.engine.Engine;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Car extends AbstractEntity {

    private String color;

    // These kind of  HasA relationships are added to demonstrate abstract factory
    @Transient
    private Chassis chassis;
    @Transient
    private List<Door> door = new ArrayList<>();
    @Transient
    private Engine engine;

    public String getBrand() {
        return "Nissan";
    }

    public String getModel() {
        return this.getClass().getSimpleName();
    }

    public String getColor() {
        if (color != null) {
            return  color;
        }
        color = getRandomColor();
        return color;
    }

    public void setColour(String colour) {
        this.color = colour;
    }

    @Override
    public boolean equals(Object other) {
        return super.equals(other);
    }

    public Chassis getChassis() {
        return chassis;
    }

    public void setChassis(Chassis chassis) {
        this.chassis = chassis;
    }

    public List<Door> getDoor() {
        return door;
    }

    public void setDoor(List<Door> door) {
        this.door = door;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    private String getRandomColor() {
        List<String> givenList = Arrays.asList("red", "green", "blue", "whit", "orange");
        Random rand = new Random();
        return givenList.get(rand.nextInt(givenList.size()));
    }

    // These kind of generic task are added to demonstrate factory method
    public void polish() {
        System.out.println("Polish the " + getModel() + ", make it shine");
    }

    public void makeTurnKeyReady() {
        System.out.println("Ready the papers, prepare the " + getModel());
    }

}
