package _05_Polymorphism_Exercises._01_Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelCostPerKm;

    public Vehicle(double fuelQuantity, double fuelCostPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.fuelCostPerKm = fuelCostPerKm;
    }

    public String drive(double distanceToDrive) {

        String message;

        double requiredFuel = distanceToDrive * this.getFuelCostPerKm();

        if (requiredFuel <= this.getFuelQuantity()) {

            DecimalFormat format = new DecimalFormat("#.##");
            message = "%s travelled %s km".formatted(this.getClass().getSimpleName(), format.format(distanceToDrive));

            this.setFuelQuantity(this.getFuelQuantity() - requiredFuel);
        }

        else {
            message = "%s needs refueling".formatted(this.getClass().getSimpleName());
        }
        return message;
    }

    public abstract void refuel(double fuelToRefill);

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelCostPerKm() {
        return fuelCostPerKm;
    }

    public void setFuelCostPerKm(double fuelCostPerKm) {
        this.fuelCostPerKm = fuelCostPerKm;
    }

    public String toString() {
        return "%s: %.2f".formatted(this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}
