package _02_Encapsulation_Exercises._02_AnimalFarm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        Chicken chicken = new Chicken(name, age);

        System.out.print(chicken);
        System.out.println();
    }
}
