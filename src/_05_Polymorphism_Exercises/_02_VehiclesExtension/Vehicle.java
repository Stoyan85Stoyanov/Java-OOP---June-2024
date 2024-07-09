package _05_Polymorphism_Exercises._02_VehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelCostPerKm;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelCostPerKm, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelCostPerKm = fuelCostPerKm;
        this.tankCapacity = tankCapacity;
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

    public void refuel(double fuelToRefill) {


        if (fuelToRefill <= 0) {
            System.out.println("Fuel must be a positive number");
            return;
        }

        else if (this.getFuelQuantity() + fuelToRefill > this.getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");
            return;
        }
        this.setFuelQuantity(this.getFuelQuantity() + fuelToRefill);
    }

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

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public String toString() {
        return "%s: %.2f".formatted(this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}
