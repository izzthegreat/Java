package com.dealership.cars;

import com.dealership.cars.domain.Car;
import com.dealership.cars.domain.CarInventory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CarsApplication {
    private static final Logger log = LoggerFactory.getLogger(CarsApplication.class);
    public static void main(String[] args) { SpringApplication.run(CarsApplication.class, args); }
    //
    @Bean
    public CommandLineRunner cars (CarInventory inventory) {
        return args -> {
            inventory.save(new Car(1997, "Hyundai", "Elantra"));
            inventory.save(new Car(2001, "Plymouth", "Breeze"));
            inventory.save(new Car(2009, "Nissan", "Altima"));
            inventory.save(new Car(2012, "Ford", "Focus"));

            List<Car> allCars = (List<Car>) inventory.findAll();
            log.info("");

            //read all Users
            log.info("All Vehicles:");
            log.info("-------------");
            for(Car car: allCars) {
                log.info(car.toString());
            }
            log.info("");

            // read an individual car by VIN
            inventory.findById(1L).ifPresent(car -> {
                log.info("Car found by VIN(1):");
                log.info("-------------------------------");
                log.info(car.toString());
                log.info("");
            });

            // read an individual car by Make & Model
            log.info("Car found by Make(Ford) and Model(Focus):");
            log.info("-----------------------------------------");
            for(Car car: inventory.findCarByMakeAndModel("Ford", "Focus")) {
                log.info(car.toString());
            }
            log.info("");

            //read all Vichicles newer than 2005
            log.info("Vehicles Newer than 2005:");
            log.info("-------------------------");
            for(Car car: inventory.findCarsByYearAfter(2005)) {
                log.info(car.toString());
            }
            log.info("");
        };
    }
}
