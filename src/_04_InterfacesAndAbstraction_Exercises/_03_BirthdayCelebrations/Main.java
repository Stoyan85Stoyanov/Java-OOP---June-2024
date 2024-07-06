package _04_InterfacesAndAbstraction_Exercises._03_BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner (System.in);

         List<Birthable> dateOfBirth = new ArrayList<>();

         String command = scanner.nextLine();
         while (!command.equals("End")) {

             String[] dataInfo = command.split("\\s+");

             switch (dataInfo[0]) {
                 case "Citizen" -> {
                     String citizenName = dataInfo[1];
                     int citizenAge = Integer.parseInt(dataInfo[2]);
                     String id = dataInfo[3];
                     String dataBirth = dataInfo[4];

                     Birthable citizen = new Citizen(citizenName, citizenAge, id, dataBirth);
                     dateOfBirth.add(citizen);
                 }
                 case "Pet" -> {
                     String petName = dataInfo[1];
                     String petDateBirth = dataInfo[2];

                     Birthable pet = new Pet(petName, petDateBirth);
                     dateOfBirth.add(pet);
                 }
             }

             command = scanner.nextLine();
         }

         String yearOfBirth = scanner.nextLine();

         dateOfBirth.stream().filter(birthable -> birthable.getBirthDate().endsWith(yearOfBirth))
                 .forEach(birthable -> System.out.println(birthable.getBirthDate()));
    }
}
