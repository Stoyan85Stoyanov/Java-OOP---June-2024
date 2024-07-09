package _05_Polymorphism_Lab._04_WildFarm;

public abstract class Food {

    protected Integer quantity;

    public Food( int quantity) {
        this.quantity = quantity;
    }


    public Integer getQuantity () {
        return quantity;
    }
}
