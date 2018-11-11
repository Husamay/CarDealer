package com.nissan.factory.abstractfactory;

import java.util.ArrayList;
import java.util.List;

import com.nissan.entity.carparts.chassis.Chassis;
import com.nissan.entity.carparts.chassis.QashQaiChassis;
import com.nissan.entity.carparts.door.Door;
import com.nissan.entity.carparts.door.QashqaiDoor;
import com.nissan.entity.carparts.engine.Engine;
import com.nissan.entity.carparts.engine.QashQaiEngine;

public class QashQaiCarPartFactory implements AbstractCarPartFactory {
    @Override
    public Chassis getChassis() {
        return new QashQaiChassis();
    }

    @Override
    public List<Door> getDoor() {
        ArrayList<Door> doors = new ArrayList<>();
        doors.add(new QashqaiDoor());
        doors.add(new QashqaiDoor());
        doors.add(new QashqaiDoor());
        doors.add(new QashqaiDoor());
        return doors;
    }

    @Override
    public Engine getEngine() {
        return new QashQaiEngine();
    }
}
