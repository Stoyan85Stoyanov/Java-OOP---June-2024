package _03_Inheritance_Lab._03_RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {

    public T getRandomElement() {
        int begin = 0;
        int end = size();

        Random random = new Random();

        int index = random.nextInt(begin, end);

        return get(index);
    }
}
