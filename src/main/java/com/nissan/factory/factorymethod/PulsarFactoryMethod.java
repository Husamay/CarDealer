package com.nissan.factory.factorymethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nissan.entity.Car;
import com.nissan.entity.Pulsar;
import com.nissan.service.CarService;

@Component
public class PulsarFactoryMethod extends AbstractFactoryMethod {

    @Autowired
    public PulsarFactoryMethod(CarService carService) {
        super(carService);
    }

    @Override
    public Car getCar() {
        return new Pulsar();
    }
}
