package com.company;

public class PetrolCar extends Car{
    private int octaneRating;
    private int kmPrL;

    public PetrolCar(String regNr, String make, String model, int year, int numDoors, int octaneRating, int kmPrL){
        super(regNr,make, model, year, numDoors);
        this.octaneRating = octaneRating;
        this.kmPrL = kmPrL;
    }

    public int getOctaneRating() {
        return octaneRating;
    }

    public void setOctaneRating(int octaneRating) {
        this.octaneRating = octaneRating;
    }

    public double getKmPrL() {
        return kmPrL;
    }

    public void setKmPrL(int kmPrL) {
        this.kmPrL = kmPrL;
    }

    @Override
    public String toString() {
        return "Petrol Car: " + '\n' +
                "Registration: " + getRegNr() + '\n' +
                "Make: " + getMake() + '\n' +
                "Model: " + getModel() + '\n' +
                "Year: " + getYear() + '\n' +
                "The octane rating is: " + octaneRating + '\n' +
                "km per liter is: " + kmPrL + '\n';
    }

    @Override
    public double calcGreenOwnerTax() {
        if (kmPrL > 20)
        {
            return 330.0;

        }else if (kmPrL > 15)
        {
            return 1050.0;

        }else if (kmPrL > 10)
        {
            return 2340.0;

        }else if (kmPrL > 5)
        {
            return 5500.0;
        }else if (kmPrL > 0)
        {
            return 10470.0;
        }

        return 0;
    }
}
