package _01_WorkingWithAbstraction._01_Lab;

import java.util.Scanner;

public class _01_RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        printRhombus(Integer.parseInt(scanner.nextLine()));

    }

    private static void printRhombus(int n) {
        printTriangle(n, true);
        printTriangle(n, false);
    }

    private static void printTriangle(int n, boolean directionUp) {
        for (int i = 1; i <= n; i++) {
            int firstSymbol = directionUp ? n - i : i;
            int secondSymbol = directionUp ? i : n - i;
            printRow(firstSymbol, " ");
            printRow(secondSymbol, "* ");
            System.out.println();
        }
    }

    private static void printRow(int count, String symbol) {
        for (int j = 1; j <= count; j++) {
            System.out.print(symbol);
        }
    }
}
