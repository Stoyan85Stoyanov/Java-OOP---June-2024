package _06_Solid_Exercises.calculator;

import _06_Solid_Exercises.products.Product;
import _06_Solid_Exercises.products.drink.Drink;
import _06_Solid_Exercises.products.food.Food;

import java.util.List;

public class QuantityCalculator implements Calculator{
    @Override
    public double sum(List<Product> products) {

        double sum = 0;

        for (Product product : products) {

            if (product instanceof Drink) {
                sum += ((Drink) product).getLiters();

            } else if (product instanceof Food) {
                sum += ((Food) product).getKilograms();
            }
        }
        return sum;
    }

    @Override
    public double average(List<Product> products) {
        return sum(products) / products.size();
    }
}
