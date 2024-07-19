package _08_ExceptionsAndErrorHandling_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _01_NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int [] range = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int begin = range[0];
        int end = range[1];

        System.out.printf("Range: [%d...%d]%n", begin, end);

        boolean isWithinRange = false;

        int number = 0;
        while (!isWithinRange) {

            String input = scanner.nextLine();

            try {
                number = Integer.parseInt(input);
                isWithinRange = number >= begin && number <= end;

            }catch (NumberFormatException ignored) {
            }

            if (!isWithinRange) {
                System.out.println("Invalid number: " + input);
            }
        }
        System.out.println("Valid number: " + number);
    }
}
