package _08_ExceptionsAndErrorHandling_Lab;

import java.util.Scanner;

public class _04_Fixing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] weekOfTheDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        try {
            for (int i = 0; i <= weekOfTheDays.length; i++) {
                System.out.println(weekOfTheDays[i]);
            }
            scanner.nextLine();

        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
    }
}


