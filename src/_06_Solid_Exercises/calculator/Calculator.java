package _06_Solid_Exercises.calculator;

import _06_Solid_Exercises.products.Product;

import java.util.List;

public interface Calculator {
    double sum(List<Product> products);

    double average(List<Product> products);
}
