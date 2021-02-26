/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humanbooster.examWSJavaMartinsAnthony;

import com.humanbooster.examWSJavaMartinsAnthony.model.Car;
import com.humanbooster.examWSJavaMartinsAnthony.model.Color;
import com.humanbooster.examWSJavaMartinsAnthony.repository.CarRepository;
import com.humanbooster.examWSJavaMartinsAnthony.repository.ColorRepository;
import java.text.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author HB
 */
@Configuration
public class LoadData {

    private static final Logger log = LoggerFactory.getLogger(LoadData.class);

    @Bean
    CommandLineRunner initDataBase(CarRepository carRepository, ColorRepository colorRepository) throws ParseException {

        if (carRepository.count() == 0) {

            Car car1 = new Car("Peugeot ", "M500", "sans-plomb 95", 2005, 60000, 10000, "La best des voitures 1");
            Car car2 = new Car("Renault", "Rt630", "sans-plomb 95", 2015, 160000, 8000, "La best des voitures 2");
            Car car3 = new Car("Mercedes ", "QQQ7", "sans-plomb 98", 1999, 8000, 50000, "La best des voitures 3");

            Color color1 = new Color("#FF0000", "Rouge");
            Color color2 = new Color("#F0FF00", "Jaune");
            Color color3 = new Color("#0500FF", "Bleu");

            return args -> {
                log.info("Preloading " + carRepository.save(car1));
                log.info("Preloading " + carRepository.save(car2));
                log.info("Preloading " + carRepository.save(car3));

                log.info("Preloading " + colorRepository.save(color1));
                log.info("Preloading " + colorRepository.save(color2));
                log.info("Preloading " + colorRepository.save(color3));
            };
        } else {
            return args -> {
                log.info("Already init !");
            };
        }
    }
}
