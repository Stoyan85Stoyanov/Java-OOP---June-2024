package _03_Inheritance_Lab._03_RandomArrayList;

public class Main {
    public static void main(String[] args) {

        RandomArrayList<Integer> randomArrayList = new RandomArrayList<>();

        for (int index = 0; index < 13; index++) {
            randomArrayList.add(index);
            
        }
        System.out.println(randomArrayList.getRandomElement());
    }
}
