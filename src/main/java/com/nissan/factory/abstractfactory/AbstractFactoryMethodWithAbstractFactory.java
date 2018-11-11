package com.nissan.factory.abstractfactory;

import com.nissan.entity.Car;
import com.nissan.service.CarService;

// its called abstract because its abstract, the design pattern is factory method nevertheless
public abstract class AbstractFactoryMethodWithAbstractFactory {

    private final CarService carService;

    AbstractFactoryMethodWithAbstractFactory(CarService carService) {
        this.carService = carService;
    }

    public Car create(AbstractCarPartFactory abstractCarPartFactory) {
        Car car;
        car = getCar(abstractCarPartFactory);
        // important task to do for every car
        car.polish();
        car.makeTurnKeyReady();
        carService.save(car);
        return car;
    }

    protected abstract Car getCar(AbstractCarPartFactory abstractCarPartFactory);
}
