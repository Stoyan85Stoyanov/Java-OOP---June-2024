package _06_Solid_Exercises;

import _06_Solid_Exercises.calculator.CalorieCalculator;
import _06_Solid_Exercises.calculator.QuantityCalculator;
import _06_Solid_Exercises.printer.Printer;

public class Main {
    public static void main(String[] args) {

        CalorieCalculator calorieCalculator = new CalorieCalculator();
        QuantityCalculator quantityCalculator = new QuantityCalculator();

        Printer printer1 = new Printer(quantityCalculator);
        Printer printer2 = new Printer(calorieCalculator);
    }
}
