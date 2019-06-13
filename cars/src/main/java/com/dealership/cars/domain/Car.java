package com.dealership.cars.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long VIN;
    private String make, model;
    private int year;

    private Car(){}

    public Car(int year, String make, String model) {
        this.year = year;
        this.make = make;
        this.model = model;
    }

    @Override
    public String toString(){
        return String.format("VIN: %d, %d %s %s", VIN, year, make, model);
    }

    public Long getVIN() { return VIN; }
    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }
    public String getModel() { return model; }
    public void setModel(String model){ this.model = model; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
}
