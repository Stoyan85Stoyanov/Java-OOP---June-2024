package _06_Solid_Exercises.products.drink;

public class Lemonade implements Drink{

    public static final double CALORIES_PER_100_GRAMS = 53.0;
    public static final double DENSITY = 0.7;

    private final double milliliters;

    public Lemonade(double milliliters) {
        this.milliliters = milliliters;
    }

    public double getMilliliters() {
        return milliliters;
    }

    @Override
    public double getCalorie() {

        double grams = getMilliliters() * Lemonade.DENSITY;
        return (Lemonade.CALORIES_PER_100_GRAMS / 100) * grams;
    }

    @Override
    public double getLiters() {

        return milliliters / 1000;
    }
}
