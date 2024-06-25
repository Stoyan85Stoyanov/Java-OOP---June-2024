package _01_WorkingWithAbstraction._01_Lab._03_StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentSystem studentSystem = new StudentSystem();

        String command = scanner.nextLine();
        while (!command.equals("Exit")) {

            String[] input = command.split("\\s+");

            String output = studentSystem.parseCommand(input);

            if (!output.isEmpty()) {
                System.out.println(output);
            }
            command = scanner.nextLine();
        }
    }
}
