package com.company;

public class ElectricCar extends Car{
    private int BatteryCapKWh;
    private int maxKm;
    private int whPrKm;


    public ElectricCar(String regNr, String make, String model, int year, int numDoors, int batteryCapKWh, int maxKm, int whPrKm) {
        super(regNr, make, model, year, numDoors);
        this.BatteryCapKWh = batteryCapKWh;
        this.maxKm = maxKm;
        this.whPrKm = whPrKm;
    }

    public int getBatteryCapKWh() {
        return BatteryCapKWh;
    }

    public void setBatteryCapKWh(int batteryCapKWh) {
        BatteryCapKWh = batteryCapKWh;
    }

    public int getMaxKm() {
        return maxKm;
    }

    public void setMaxKm(int maxKm) {
        this.maxKm = maxKm;
    }

    public int getWhPrKm() {
        return whPrKm;
    }

    public void setWhPrKm(int whPrKm) {
        this.whPrKm = whPrKm;
    }

    @Override
    public String toString() {
        return "Electric Car: " + '\n' +
                "Registration: " + getRegNr() + '\n' +
                "Make: " + getMake() + '\n' +
                "Model: " + getModel() + '\n' +
                "Year: " + getYear() + '\n' +
                "Battery capacity in Kwh is: " + BatteryCapKWh + '\n' +
                "max range in Km: " + maxKm + '\n' +
                "Watts hour per km: " + whPrKm + '\n';
    }

    @Override
    public double calcGreenOwnerTax()
    {
        int kmPrL = (int) (100/ (whPrKm / 91.25));

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
