package _06_Solid_Exercises.products.food;

public class Chips implements Food{
    public static final double CALORIES_PER_100_GRAMS = 529.0;

    private final double grams;

    public Chips(double grams) {
        this.grams = grams;
    }

    public double getGrams() {
        return grams;
    }

    @Override
    public double getCalorie() {

        return  (Chips.CALORIES_PER_100_GRAMS / 100) * getGrams();
    }

    @Override
    public double getKilograms() {
        return grams / 1000;
    }
}
