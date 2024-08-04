package christmasPastryShop.entities.delicacies;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

public abstract class BaseDelicacy implements Delicacy {
     private String name;
     private double portion;
     private double price;

    public BaseDelicacy(String name, double portion, double price) { // Constructor
        setName(name);
        setPortion(portion);
        setPrice(price);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) { // Ако името е null или празно място
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME);
        }
        this.name = name;
    }

    public void setPortion(double portion) {
        if (portion <= 0) { // Ако частта е по-малка или равна на 0
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PORTION);
        }
        this.portion = portion;
    }

    public void setPrice(double price) {
        if(price <= 0) { // Ако цената е по-малка или равна на 0
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PRICE);
        }
        this.price = price;
    }
    @Override
    public String toString() {
        // Връща низ с информация за всеки деликатес
        return String.format("%s: %.2fg - %.2f", this.name, this.portion, this.price);
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPortion() {
        return portion;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
