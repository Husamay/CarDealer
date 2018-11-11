package com.nissan.factory.abstractfactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nissan.entity.Car;
import com.nissan.entity.Juke;
import com.nissan.service.CarService;

@Component
public class QashqaiFactoryMethod extends AbstractFactoryMethodWithAbstractFactory{

    @Autowired
    public QashqaiFactoryMethod(CarService carService) {
        super(carService);
    }

    @Override
    public Car getCar(AbstractCarPartFactory abstractCarPartFactory) {
        Juke juke = new Juke();
        juke.setChassis(abstractCarPartFactory.getChassis());
        juke.setDoor(abstractCarPartFactory.getDoor());
        juke.setEngine(abstractCarPartFactory.getEngine());
        return juke;
    }
}
