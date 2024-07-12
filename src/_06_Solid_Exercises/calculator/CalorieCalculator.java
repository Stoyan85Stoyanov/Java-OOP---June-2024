package _06_Solid_Exercises.calculator;


import _06_Solid_Exercises.products.Product;

import java.util.List;

public class CalorieCalculator extends QuantityCalculator implements Calculator{


    @Override
    public double sum(List<Product> products) {
        double sum = 0;
        for (Product product : products) {
            sum += product.getCalorie();
        }
        return sum;
    }

    @Override
    public double average(List<Product> products) {
        return sum(products) / products.size();
    }
}
