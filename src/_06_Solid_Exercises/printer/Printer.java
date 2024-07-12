package _06_Solid_Exercises.printer;

import _06_Solid_Exercises.calculator.Calculator;
import _06_Solid_Exercises.calculator.QuantityCalculator;
import _06_Solid_Exercises.products.Product;

import java.util.List;

public class Printer {
    private static final String SUM = "Sum: %f";
    private static final String AVERAGE = "Average: %f";

    private final Calculator calculator;

    public Printer(QuantityCalculator calculator) {
        this.calculator = calculator;
    }

    public void printSum(List<Product> products) {
        System.out.printf((SUM) + "%n", calculator.sum(products));
    }

    public void printAverage(List<Product> products) {
        System.out.printf((AVERAGE) + "%n", calculator.average(products));
    }
}
