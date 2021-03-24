package com.company;

public class DieselCar extends Car{
    boolean hasParticleFilter;
    int kmPrL;

    public DieselCar(String regNr, String make, String model, int year, int doors, boolean hasParticleFilter , int kmPrL) {
        super(regNr, make, model, year, doors);
        this.hasParticleFilter = hasParticleFilter;
        this.kmPrL = kmPrL;

    }

    public boolean isParticleFilter() {
        return hasParticleFilter;
    }

    public void setParticleFilter(boolean hasParticleFilter) {
        this.hasParticleFilter = hasParticleFilter;
    }

    public int getKmPrL() {
        return kmPrL;
    }

    public void setKmPrL(int kmPrL) {
        this.kmPrL = kmPrL;
    }

    @Override
    public String toString() {
        return "Diesel Car: " + '\n' +
                "Has a particle filter: " + hasParticleFilter + '\n' +
                "km per liter is: " + kmPrL + '\n';
    }

    @Override
    public double calcGreenOwnerTax() {

        double countervaillingCharge;
        if (hasParticleFilter){
            countervaillingCharge = 0;
        }else{
            countervaillingCharge = 1000;
        }

        if (kmPrL > 20)
        {
            return 330.0 + 130.0 + countervaillingCharge;

        }else if (kmPrL > 15)
        {
            return 1050.0 + 1390.0 + countervaillingCharge;

        }else if (kmPrL > 10)
        {
            return 2340.0 + 1850.0 + countervaillingCharge;

        }else if (kmPrL > 5)
        {
            return 5500.0 + 2770.0 + countervaillingCharge;

        }else if (kmPrL > 0)
        {
            return 10470.0 + 15260.0 + countervaillingCharge;
        }
        return -1;
    }
}
