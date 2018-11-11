package com.nissan.factory.factorymethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nissan.entity.Car;
import com.nissan.entity.Juke;
import com.nissan.service.CarService;

@Component
public class JukeFactoryMethod extends AbstractFactoryMethod{

    @Autowired
    public JukeFactoryMethod(CarService carService) {
        super(carService);
    }

    @Override
    public Car getCar() {
        return new Juke();
    }
}
