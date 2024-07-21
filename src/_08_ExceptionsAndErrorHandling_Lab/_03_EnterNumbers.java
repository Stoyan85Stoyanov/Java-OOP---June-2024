package _08_ExceptionsAndErrorHandling_Lab;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_EnterNumbers {

    public static class NumberRangeException extends RuntimeException{
        public NumberRangeException (String message, Throwable cause) {
            super(message, cause);
        }

        public NumberRangeException (String message){
            super(message);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

         int start = 1;
         int end = 100;

        ArrayList<String> numbers = new ArrayList<>();

        while (numbers.size() != 10) {
             try {
                 start = readNumber(start, end, scanner);
                 numbers.add(String.valueOf(start));

             }catch (NumberRangeException e) {
                 System.out.println(e.getMessage());
             }
        }
        System.out.println(numbers.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }

    private static int readNumber(int start, int end, Scanner scanner) {

        int number;

        try {
            number = Integer.parseInt(scanner.nextLine());

        }catch (NumberFormatException e) {
            throw new NumberRangeException("Invalid Number!", e);
        }
         if (number <= start || number >= end) {
             throw new NumberRangeException("Your number is not in range " + start + " - 100!");
         }
         return number;
    }
}
