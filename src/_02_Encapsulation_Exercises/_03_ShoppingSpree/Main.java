package _02_Encapsulation_Exercises._03_ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<Person> people = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        String peopleData = scanner.nextLine();
        String productData = scanner.nextLine();


        for (String personInfo : peopleData.split(";")) {
            String name = personInfo.split("=")[0];
            double money = Double.parseDouble(personInfo.split("=")[1]);
            Person person = new Person(name, money);
            people.add(person);
        }

        for (String productInfo : productData.split(";")) {
            String name = productInfo.split("=")[0];
            double cost = Double.parseDouble(productInfo.split("=")[1]);
            Product product = new Product(name, cost);
            products.add(product);
        }

        String command = scanner.nextLine();
        while (!command.equals("END")) {

            String personName = command.split("\\s+")[0];
            String productName = command.split("\\s+")[1];

            Person person = people.stream().filter(persons -> persons.getName().equals(personName)).findFirst().get();
            Product product = products.stream().filter(persons -> persons.getName().equals(productName)).findFirst().get();

            person.buyProduct(product);

            command = scanner.nextLine();
        }
    }
}

