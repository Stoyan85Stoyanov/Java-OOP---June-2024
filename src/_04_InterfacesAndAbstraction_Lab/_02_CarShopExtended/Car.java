package _04_InterfacesAndAbstraction_Lab._02_CarShopExtended;

public interface Car {

    Integer TIERS = 4;

    String getModel();

    String getColor();

    Integer getHorsePower();

    String countryProduced();
}
