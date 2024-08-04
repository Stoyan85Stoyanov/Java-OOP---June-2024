package christmasPastryShop.entities.booths;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseBooth implements Booth {
    private Collection<Delicacy> delicacyOrders;
    private Collection<Cocktail> cocktailOrders;
    private int boothNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    public BaseBooth(int boothNumber, int capacity, double pricePerPerson) {
        this.boothNumber = boothNumber;
        setCapacity(capacity);
//        setNumberOfPeople(numberOfPeople);
        this.pricePerPerson = pricePerPerson;
        this.isReserved = false;
        this.delicacyOrders = new ArrayList<>();
        this.cocktailOrders = new ArrayList<>();
        this.price = 0;
    }

    public void setCapacity(int capacity) {
        if (capacity <= 0) { // Не може да бъде по-малко от нула
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0){ // Не може да бъде по-малко или равно на 0
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople; // броя на хората, които искат кабина
    }

    @Override
    public int getBoothNumber() {
        return this.boothNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }
    @Override
    public double getPrice() {
        return this.price;
    }
    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    @Override
    public void reserve(int numberOfPeople) { //Резервирайте щанда с дадения брой хора и изчислете цената на щанда
        this.setNumberOfPeople(numberOfPeople);
        isReserved = true;
        this.price = this.pricePerPerson * numberOfPeople;
    }

    @Override
    public double getBill() { // Връща сметката за сепарето, всички поръчани коктейли и деликатеси
        double bill = 0;
        bill += cocktailOrders.stream().mapToDouble(Cocktail::getPrice).sum();
        bill += delicacyOrders.stream().mapToDouble(Delicacy::getPrice).sum();
        bill += getPrice();
        return bill;
    }

    @Override
    public void clear() { // Премахва всички поръчани коктейли и деликатеси и накрая освобождава сепарето, задава броя на хората и цената на 0
        this.isReserved = false;
        this.cocktailOrders.clear();
        this.delicacyOrders.clear();
        this.numberOfPeople = 0;
        this.price = 0;
    }
}
