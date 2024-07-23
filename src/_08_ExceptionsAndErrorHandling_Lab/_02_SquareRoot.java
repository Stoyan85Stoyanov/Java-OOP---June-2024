package _08_ExceptionsAndErrorHandling_Lab;

import java.util.Scanner;

public class _02_SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String numbers = scanner.nextLine();

        try {
            double sqrt = sqrt(Integer.parseInt(numbers));
            System.out.printf("%.2f%n", sqrt);

        }catch (NumberFormatException e) {
            System.out.println("Invalid");

        }finally {
            System.out.println("Goodbye");
        }

    }
    public static double sqrt (double number) {

        if (number <= 0) {
            throw new NumberFormatException("Invalid");
        }
        return Math.sqrt(number);
    }
}


