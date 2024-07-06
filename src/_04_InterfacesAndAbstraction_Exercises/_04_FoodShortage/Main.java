package _04_InterfacesAndAbstraction_Exercises._04_FoodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner (System.in);

       List<Citizen> citizens = new ArrayList<>();
       List<Rebel> rebels = new ArrayList<>();
       
       int number = Integer.parseInt(scanner.nextLine());
        for (int row = 0; row < number; row++) {

            String[] command = scanner.nextLine().split("\\s+");

            if (command.length == 4) {
                String name = command[0];
                int age = Integer.parseInt(command[1]);
                String id = command[2];
                String date = command[3];

                Citizen citizen = new Citizen(name, age, id, date);
                citizens.add(citizen);

            }else {
                String name = command[0];
                int age = Integer.parseInt(command[1]);
                String group = command[2];

                Rebel rebel = new Rebel(name, age,group);
                rebels.add(rebel);
            }
        }
        String name = scanner.nextLine();
        while (!name.equals("End")) {

            for (Citizen citizen: citizens) {
                if (citizen.getName().equals(name)){
                    citizen.buyFood();
                }
            }
            for (Rebel rebel: rebels) {
                if (rebel.getName().equals(name)) {
                    rebel.buyFood();
                }
            }
            name = scanner.nextLine();
        }

        int totalFood = 0;

        for (Citizen citizen: citizens) {
            totalFood += citizen.getFood();
        }
        for (Rebel rebel: rebels) {
            totalFood += rebel.getFood();
        }
        System.out.println(totalFood);
    }
}
