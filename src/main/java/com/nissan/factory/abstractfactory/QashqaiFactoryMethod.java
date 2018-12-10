package com.nissan.factory.abstractfactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nissan.entity.Car;
import com.nissan.entity.Qashqai;
import com.nissan.service.CarService;

@Component
public class QashqaiFactoryMethod extends AbstractFactoryMethodWithAbstractFactory{

    @Autowired
    public QashqaiFactoryMethod(CarService carService) {
        super(carService);
    }

    @Override
    public Car getCar(AbstractCarPartFactory abstractCarPartFactory) {
        Qashqai qashqai = new Qashqai();
        qashqai.setChassis(abstractCarPartFactory.getChassis());
        qashqai.setDoor(abstractCarPartFactory.getDoor());
        qashqai.setEngine(abstractCarPartFactory.getEngine());
        return qashqai;
    }
}
