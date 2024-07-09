package _05_Polymorphism_Exercises._02_VehiclesExtension;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double fuelCostPerKm, double tankCapacity) {

        super(fuelQuantity, fuelCostPerKm + 1.6, tankCapacity);
    }

    @Override
    public void refuel(double fuelToRefill) {

        double totalFuelToRefill = fuelToRefill * 0.95;

        super.refuel(totalFuelToRefill);
    }
}
