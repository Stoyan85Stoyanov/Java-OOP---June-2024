package _05_Polymorphism_Exercises._01_Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] carDetails = scanner.nextLine().split("\\s+");
        String[] truckDetails = scanner.nextLine().split("\\s+");


        double carFuelQuantity = Double.parseDouble(carDetails[1]);
        double carFuelCostPerKm = Double.parseDouble(carDetails[2]);

        double truckFuelQuantity = Double.parseDouble(truckDetails[1]);
        double truckFuelCostPerKm = Double.parseDouble(truckDetails[2]);

        Car car = new Car(carFuelQuantity, carFuelCostPerKm);
        Truck truck = new Truck(truckFuelQuantity, truckFuelCostPerKm);


        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {


            String[] commandParts = scanner.nextLine().split("\\s+");
            String commandName = commandParts[0];
            String vehicleType = commandParts[1];
            double numbers = Double.parseDouble(commandParts[2]);

            switch (commandName) {

                case "Drive":

                    if (vehicleType.equals("Car")) {
                        System.out.println(car.drive(numbers));

                    } else {
                        System.out.println(truck.drive(numbers));
                    }
                    break;

                case "Refuel":

                    if (vehicleType.equals("Car")) {
                        car.refuel(numbers);

                    } else {
                        truck.refuel(numbers);
                    }
                    break;
            }
        }
        System.out.println(car);
        System.out.println(truck);
    }
}
