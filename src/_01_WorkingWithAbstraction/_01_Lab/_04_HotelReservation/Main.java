package _01_WorkingWithAbstraction._01_Lab._04_HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        double priceDay = Double.parseDouble(tokens[0]);
        int days = Integer.parseInt(tokens[1]);
        String season = tokens[2];
        String discount = tokens[3];

        Season seasonEnum = Season.valueOf(season.toUpperCase());

        DiscountType discountType = DiscountType.fromString(discount);

        double cost = priceDay * days * seasonEnum.getMultiplier()* discountType.getValue();

        System.out.printf("%.2f", cost);
    }
}
