package com.company;

import java.util.ArrayList;

public class Garage {
    private String name;
    private ArrayList<Car> garage = new ArrayList<>();

    public Garage(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize(){
        return garage.size();
    }

    public Car getCarAt(int index){
        return garage.get(index);
    }

    public void addCar(Car car){
        garage.add(car);
    }

    public double calcGarageGreenTax(){
        double total = 0;
        for (Car car: garage) {
            total += car.calcGreenOwnerTax();
        }
        return total;
    }

    // prints out the tax for the individual cars in the array
    public void printIndividualTax(){
        for(int i = 0; i < garage.size() ; i++) {
            Car tempCar = garage.get(i);
            System.out.println(tempCar.getMake() + " "+ tempCar.getModel() + "\nGreen tax: " + tempCar.calcGreenOwnerTax() + "\n");
        }
    }

    @Override
    public String toString() {
        String parkedCars = "";
        for (Car car: garage) {
            parkedCars += car.toString() + '\n';
        }
        return "Cars parked in " + name + "\n" + parkedCars;
    }
}
