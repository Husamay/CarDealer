package com.nissan.factory.factorymethod;

import com.nissan.entity.Car;
import com.nissan.service.CarService;

// its called abstract because its abstract, the design pattern is factory method nevertheless
public abstract class AbstractFactoryMethod {

    private final CarService carService;

    AbstractFactoryMethod(CarService carService) {
        this.carService = carService;
    }

    public Car create() {
        Car car;
        car = getCar();
        // important task to do for every car
        car.polish();
        car.makeTurnKeyReady();
        carService.save(car);
        return car;
    }

    protected abstract Car getCar();
}
