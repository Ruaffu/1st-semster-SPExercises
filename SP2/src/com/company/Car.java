package com.company;

public abstract class Car {
    private String regNr;
    private String make;
    private String model;
    private int year;
    private int doors;

    public Car(String regNr, String make, String model, int year, int doors){
        this.regNr = regNr;
        this.make = make;
        this.model = model;
        this.year = year;
        this.doors = doors;

    }

    public abstract double calcGreenOwnerTax();

    public String getRegNr() {
        return regNr;
    }

    public void setRegNr(String regNr) {
        this.regNr = regNr;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    @Override
    public String toString() {
        return "Car: " +
                "Registration number: " + regNr + '\n' +
                "Make: " + make + '\n' +
                "Model: " + model + '\n' +
                "Year: " + year + '\n' +
                "Number of doors: " + doors;
    }
}
