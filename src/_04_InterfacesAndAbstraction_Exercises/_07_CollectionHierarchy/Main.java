package _04_InterfacesAndAbstraction_Exercises._07_CollectionHierarchy;


import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] input = scanner.nextLine().split("\\s+");

    int number = Integer.parseInt(scanner.nextLine());

    AddCollection addCollection = new AddCollection();
    AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
    MyListImpl myListImpl = new MyListImpl();

        Arrays.stream(input).forEach(p -> System.out.printf("%d ", addCollection.add(p)));
        System.out.println();

        Arrays.stream(input).forEach(p -> System.out.printf("%d ", addRemoveCollection.add(p)));
        System.out.println();

        Arrays.stream(input).forEach(p -> System.out.printf("%d ", myListImpl.add(p)));
        System.out.println();

        IntStream.range(0, number).forEach(p -> System.out.printf("%s ", addRemoveCollection.remove()));
        System.out.println();

        IntStream.range(0, number).forEach(p -> System.out.printf("%s ", myListImpl.remove()));
    }
}
