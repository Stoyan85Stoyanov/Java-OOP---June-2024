package _01_WorkingWithAbstraction._02_Exercise._02_CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        CardRank[] cardRanks = CardRank.values();
        System.out.println("Card Ranks:");

        for (CardRank cardRank : cardRanks) {
            int ordinalValue = cardRank.ordinal();
            System.out.printf("Ordinal value: %d; Name value: %s%n", ordinalValue, cardRank);
        }
    }
}

