package _04_InterfacesAndAbstraction_Lab._01_CarShop;

import java.io.Serializable;

public interface Car extends Serializable {

    Integer TIRES = 4;

    String getModel();

    String getColor();

    Integer getHorsePower();

    String countryProduced();

}
