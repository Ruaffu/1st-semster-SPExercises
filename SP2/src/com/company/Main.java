package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Garage garage = new Garage();

        garage.addCar(new PetrolCar("CH19231", "Ford", "Fiesta", 2015, 5, 95, 15));
        garage.addCar(new DieselCar("RT15684", "VW", "Golf", 1999, 3, false, 10));
        garage.addCar(new ElectricCar("BM25786", "Tesla","Model S", 2017, 5, 100, 560,184));

        System.out.println(garage.toString());
        System.out.println("The total green tax is: " + garage.calcGarageGreenTax()+"\n");
        
    }
}
