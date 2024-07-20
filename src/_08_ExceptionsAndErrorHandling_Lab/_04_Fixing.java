package _08_ExceptionsAndErrorHandling_Lab;

import java.util.Scanner;

public class _04_Fixing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        try {
            for (int i = 0; i <= weekDays.length; i++) {
                System.out.println(weekDays[i]);
            }
            scanner.nextLine();

        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
    }
}


