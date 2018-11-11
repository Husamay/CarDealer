package com.nissan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.nissan.entity.Car;
import com.nissan.repository.EveliaRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = { EveliaRepository.class })
@EntityScan(basePackageClasses = { Car.class })
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
