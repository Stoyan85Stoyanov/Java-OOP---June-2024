package _05_Polymorphism_Exercises._03_Word_;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());


        CommandInterface commandInterface = Initialization.buildCommandInterface(text);

        String input = scanner.nextLine();

        while (!input.equals("exit")) {

            commandInterface.handleInput(input);
            input = scanner.nextLine();
        }

        System.out.println(text);
    }
}
