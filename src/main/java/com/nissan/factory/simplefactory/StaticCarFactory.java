package com.nissan.factory.simplefactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nissan.entity.Car;
import com.nissan.entity.Evelia;
import com.nissan.entity.Juke;
import com.nissan.entity.Micra;
import com.nissan.entity.Pulsar;
import com.nissan.entity.Qashqai;
import com.nissan.entity.XTrail;
import com.nissan.service.CarService;

@Component
public class  StaticCarFactory {

    private static CarService carService;

    @Autowired
    public StaticCarFactory(CarService carService) {
        this.carService = carService;
    }

    public static Car create(String carType) {
        if ("Evelia".equals(carType)) {
            return carService.save(new Evelia());
        } else if ("Juke".equals(carType)) {
            return carService.save(new Juke());
        } else if ("Micra".equals(carType)) {
            return carService.save(new Micra());
        } else if ("Pulsar".equals(carType)) {
            return carService.save(new Pulsar());
        } else if ("Qashqai".equals(carType)) {
            return carService.save(new Qashqai());
        } else if ("XTrail".equals(carType)) {
            return carService.save(new XTrail());
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
