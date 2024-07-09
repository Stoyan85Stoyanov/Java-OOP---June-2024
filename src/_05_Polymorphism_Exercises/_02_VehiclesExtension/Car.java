package _05_Polymorphism_Exercises._02_VehiclesExtension;

public class Car extends Vehicle {
    public Car(double fuelQuantity, double fuelCostPerKm, double tankCapacity) {
        super(fuelQuantity, fuelCostPerKm + 0.9, tankCapacity);
    }
}
