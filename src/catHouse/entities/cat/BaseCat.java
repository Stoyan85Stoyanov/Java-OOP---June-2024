package catHouse.entities.cat;

import catHouse.common.ExceptionMessages;

public abstract class BaseCat implements Cat { // BaseCat is a base class of any type of cat and it should not be able to be instantiated

    private String name;
    private String breed;
    private int kilograms;
    private double price;

    public BaseCat(String name, String breed, int kilograms, double price) { // Constructor
        this.setName(name);
        this.setBreed(breed);
        this.setPrice(price);
        this.setKilograms(kilograms);
    }

    @Override
    public String getName() { // implements Cat
        return this.name;
    }

    @Override
    public void setName(String name) {  // implements Cat
       if (name == null || name.trim().isEmpty()) {
           throw new NullPointerException(ExceptionMessages.CAT_NAME_NULL_OR_EMPTY);
       }
       this.name = name;
    }

    @Override
    public int getKilograms() {  // implements Cat
        return this.kilograms;
    }

    @Override
    public double getPrice() { // implements Cat
        return this.price;
    }

    @Override   // Keep in mind that some breeds of Cat can implement the method differently
    abstract public void eating();  // за да може да се implements Cat по различен начин



    public void setBreed(String breed) {
        if (breed == null || breed.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.CAT_BREED_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.breed = breed;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.CAT_PRICE_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
        }
        this.price = price;
    }

    public void setKilograms(int kilograms) {
        this.kilograms = kilograms;
    }
}
