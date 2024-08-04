package christmasPastryShop.entities.cocktails;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;

public abstract class BaseCocktail implements Cocktail {

    private String name;
    private int size;
    private double price;
    private String brand;

    public BaseCocktail(String name, int size, double price, String brand) {
        setName(name);
        setSize(size);
        setPrice(price);
        setBrand(brand);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) { // Ако името е null или празно място
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME);
        }
        this.name = name;
    }

    public void setSize(int size) { // Ако размерът е по-малък или равен на 0
        if (size <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_SIZE);
        }
        this.size = size;
    }

    public void setPrice(double price) { // Ако цената е по-малка или равна на 0
        if (price <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PRICE);
        }
        this.price = price;
    }

    public void setBrand(String brand) {
        if (name == null || name.trim().isEmpty()) { // Ако името е null или празно място
            throw new IllegalArgumentException(ExceptionMessages.INVALID_BRAND);
        }
        this.brand = brand;
    }

    @Override
    public String toString() {
        return String.format("%s %s - %dml - %.2flv", this.name, this.brand, this.size, this.price);
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getBrand() {
        return brand;
    }


}
