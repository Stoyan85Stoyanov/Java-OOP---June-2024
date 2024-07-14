package _06_Solid_Exercises.products.food;

public class Chocolate implements Food{

    public static final double CALORIES_PER_100_GRAMS = 575.0;

    private final double grams;

    public Chocolate(double grams) {
        this.grams = grams;
    }

    public double getGrams() {
        return grams;
    }

    @Override
    public double getCalorie() {

        return (Chocolate.CALORIES_PER_100_GRAMS / 100) * getGrams();
    }

    @Override
    public double getKilograms() {
        return grams / 1000;
    }
}
