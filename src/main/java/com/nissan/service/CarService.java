package com.nissan.service;

import java.io.Serializable;
import java.util.Comparator;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nissan.entity.Car;
import com.nissan.entity.Evelia;
import com.nissan.entity.Juke;
import com.nissan.entity.Micra;
import com.nissan.entity.Pulsar;
import com.nissan.entity.Qashqai;
import com.nissan.entity.XTrail;
import com.nissan.repository.EveliaRepository;
import com.nissan.repository.JukeRepository;
import com.nissan.repository.MicraRepository;
import com.nissan.repository.PulsarRepository;
import com.nissan.repository.QashqaiRepository;
import com.nissan.repository.XTrailRepository;

@Component
public class CarService implements Serializable {
    private EveliaRepository eveliaRepository;
    private JukeRepository jukeRepository;
    private MicraRepository micraRepository;
    private PulsarRepository pulsarRepository;
    private QashqaiRepository qashqaiRepository;
    private XTrailRepository xTrailRepository;

    @Autowired
    public CarService(EveliaRepository eveliaRepository,
            JukeRepository jukeRepository, MicraRepository micraRepository,
            PulsarRepository pulsarRepository,
            QashqaiRepository qashqaiRepository,
            XTrailRepository xTrailRepository) {
        this.eveliaRepository = eveliaRepository;
        this.jukeRepository = jukeRepository;
        this.micraRepository = micraRepository;
        this.pulsarRepository = pulsarRepository;
        this.qashqaiRepository = qashqaiRepository;
        this.xTrailRepository = xTrailRepository;
    }

    public Stream<Car> findAll(int offset, int limit) {
        return (Stream<Car>) Stream.of(eveliaRepository.findAll().stream(),
                jukeRepository.findAll().stream(),
                micraRepository.findAll().stream(),
                pulsarRepository.findAll().stream(),
                qashqaiRepository.findAll().stream(),
                xTrailRepository.findAll().stream()).reduce(Stream::concat)
                .orElseGet(Stream::empty).sorted(Comparator.comparing(Car::getid)).skip(offset).limit(limit);
    }

    public Car save(Car car) {
        if ("Evelia".equals(car.getModel())) {
            return eveliaRepository.save((Evelia) car);
        } else if ("Juke".equals(car.getModel())) {
            return jukeRepository.save((Juke) car);
        } else if ("Micra".equals(car.getModel())) {
            return micraRepository.save((Micra) car);
        } else if ("Pulsar".equals(car.getModel())) {
            return pulsarRepository.save((Pulsar) car);
        } else if ("Qashqai".equals(car.getModel())) {
            return qashqaiRepository.save((Qashqai) car);
        } else if ("XTrail".equals(car.getModel())) {
            return xTrailRepository.save((XTrail) car);
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
