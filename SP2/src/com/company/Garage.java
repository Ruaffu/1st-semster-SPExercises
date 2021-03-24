package com.company;

import java.util.ArrayList;

public class Garage {
    private ArrayList<Car> garage = new ArrayList<>();

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

    @Override
    public String toString() {
        String parkedCars = "";
        for (Car car: garage) {
            parkedCars += car.toString() + '\n';
        }
        return parkedCars;
    }
}
