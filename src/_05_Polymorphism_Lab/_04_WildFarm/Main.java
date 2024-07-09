package _05_Polymorphism_Lab._04_WildFarm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            Functionality.execute(input.split("\\s+"), scanner.nextLine().split("\\s+"));

            input = scanner.nextLine();
        }
        Functionality.getAnimalsInfo().forEach(e -> System.out.println(e.toString()));
    }
}

