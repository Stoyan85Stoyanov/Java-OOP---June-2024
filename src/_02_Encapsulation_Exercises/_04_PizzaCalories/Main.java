package _02_Encapsulation_Exercises._04_PizzaCalories;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] pizzaInformation = scanner.nextLine().split("\\s+");

        String name = pizzaInformation[1];
        int countTopping = Integer.parseInt(pizzaInformation[2]);


        try {
            Pizza pizza = new Pizza(name, countTopping);

            String[] doughInfo = scanner.nextLine().split("\\s+");
            String flourType = doughInfo[1];
            String bakingTechnique = doughInfo[2];
            double weight = Double.parseDouble(doughInfo[3]);

            Dough dough = new Dough(flourType, bakingTechnique, weight);
            pizza.setDough(dough);

            String input = scanner.nextLine();

            while (!input.equals("END")) {

                String[] toppingInfo = input.split("\\s+");
                String toppingType = toppingInfo[1];
                double toppingWeight = Double.parseDouble(toppingInfo[2]);

                Topping topping = new Topping(toppingType, toppingWeight);
                pizza.addTopping(topping);

                input = scanner.nextLine();
            }

            System.out.println(pizza);

        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
