package com.dealership.cars.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CarInventory extends CrudRepository <Car, Long> {
    List<Car> findCarByMakeAndModel (String make, String model);
    List<Car> findCarsByYearAfter(int year);
}
