package _07_Reflection_Lab._03_HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
public class Main {

    public static void main(String[] args) {

        Arrays.stream(Reflection.class.getDeclaredFields())
                .filter(field->!Modifier.isPrivate(field.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(field->System.out.printf("%s must be private!%n",field.getName()));

        Arrays.stream(Reflection.class.getDeclaredMethods())
                .filter(method->method.getName().startsWith("get"))
                .sorted(Comparator.comparing(Method::getName))
                .filter(getter->!Modifier.isPublic(getter.getModifiers()))
                .forEach(getter -> System.out.printf("%s have to be public!%n", getter.getName()));

        Arrays.stream(Reflection.class.getDeclaredMethods())
                .filter(method->method.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .filter(setter->!Modifier.isPrivate(setter.getModifiers()))
                .forEach(setter -> System.out.printf("%s have to be private!%n", setter.getName()));

    }
}
