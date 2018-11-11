package com.nissan.factory.abstractfactory;

import java.util.List;

import com.nissan.entity.carparts.chassis.Chassis;
import com.nissan.entity.carparts.door.Door;
import com.nissan.entity.carparts.engine.Engine;

public interface AbstractCarPartFactory {

    Chassis getChassis();

    List<Door> getDoor();

    Engine getEngine();
}


