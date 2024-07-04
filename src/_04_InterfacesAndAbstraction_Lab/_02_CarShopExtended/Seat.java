package _04_InterfacesAndAbstraction_Lab._02_CarShopExtended;

public class Seat extends CarImpl implements Sellable {

    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        String firstRow = super.toString();
        String secondRow = "%s sells for %f".formatted(getModel(), price);

        builder.append(firstRow).append(System.lineSeparator());
        builder.append(secondRow);

        return builder.toString();
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
