package _05_Polymorphism_Exercises._02_VehiclesExtension;

public class Bus extends Vehicle {

    private final double emptyBusFuelCostPerKm;
    private final double nonEmptyBusFuelCostPerKm;

    public Bus(double fuelQuantity, double fuelCostPerKm, double tankCapacity) {

        super(fuelQuantity, fuelCostPerKm, tankCapacity);

        this.emptyBusFuelCostPerKm = fuelCostPerKm;
        this.nonEmptyBusFuelCostPerKm = fuelCostPerKm + 1.4;
    }


    public String drive(double distance) {

        this.setFuelCostPerKm(nonEmptyBusFuelCostPerKm);

        return super.drive(distance);
    }


    public String driveEmpty(double distance) {

        this.setFuelCostPerKm(emptyBusFuelCostPerKm);

        return super.drive(distance);
    }
}
