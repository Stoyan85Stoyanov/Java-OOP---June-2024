package catHouse.entities.toys;

public abstract class BaseToy implements Toy{ // BaseToy is a base class of any type of toy and it should not be able to be instantiated
    private int softness;
    private double price;

    public BaseToy(int softness, double price) {  // Constructor
        this.softness = softness;
        this.price = price;
    }
    @Override
    public int getSoftness() { // implements Toy
        return this.softness;
    }
    @Override
    public double getPrice() { // implements Toy
        return this.price;
    }
}
