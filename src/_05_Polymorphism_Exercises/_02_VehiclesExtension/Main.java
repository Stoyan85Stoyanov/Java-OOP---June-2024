package _05_Polymorphism_Exercises._02_VehiclesExtension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] carDetails = scanner.nextLine().split("\\s+");
        String[] truckDetails = scanner.nextLine().split("\\s+");
        String[] busDetails = scanner.nextLine().split("\\s+");


        double carFuelQuantity = Double.parseDouble(carDetails[1]);
        double carFuelCostPerKm = Double.parseDouble(carDetails[2]);
        double carTankCapacity = Double.parseDouble(carDetails[3]);


        double truckFuelQuantity = Double.parseDouble(truckDetails[1]);
        double truckFuelCostPerKm = Double.parseDouble(truckDetails[2]);
        double truckTankCapacity = Double.parseDouble(truckDetails[3]);


        double busFuelQuantity = Double.parseDouble(busDetails[1]);
        double busFuelCostPerKm = Double.parseDouble(busDetails[2]);
        double busTankCapacity = Double.parseDouble(busDetails[3]);

        Car car = new Car(carFuelQuantity, carFuelCostPerKm, carTankCapacity);
        Truck truck = new Truck(truckFuelQuantity, truckFuelCostPerKm, truckTankCapacity);
        Bus bus = new Bus(busFuelQuantity, busFuelCostPerKm, busTankCapacity);


        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {

            String[] commandParts = scanner.nextLine().split("\\s+");

            String command = commandParts[0];
            String vehicleType = commandParts[1];
            double numbers = Double.parseDouble(commandParts[2]);

            switch (command) {

                case "Drive":

                    if (vehicleType.equals("Car")) {
                        System.out.println(car.drive(numbers));

                    } else if (vehicleType.equals("Bus")) {
                        System.out.println(bus.drive(numbers));

                    } else {
                        System.out.println(truck.drive(numbers));
                    }
                    break;

                case "DriveEmpty":

                    System.out.println(bus.driveEmpty(numbers));
                    break;

                case "Refuel":

                    if (vehicleType.equals("Car")) {
                        car.refuel(numbers);

                    } else if (vehicleType.equals("Bus")) {
                        bus.refuel(numbers);

                    } else {
                        truck.refuel(numbers);
                    }
                    break;
            }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
