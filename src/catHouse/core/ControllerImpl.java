package catHouse.core;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller{

    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() { // Constructor
        this.toys = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
         House house;

        if (type.equals("ShortHouse")) {
           house = new ShortHouse(name);

        } else if (type.equals("LongHouse")) {
            house = new LongHouse(name);

        }else {
            throw new NullPointerException(ExceptionMessages.INVALID_HOUSE_TYPE);
        }
         this.houses.add(house);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy; // създавам играчка

        if (type.equals("Ball")) {
            toy = new Ball();

        } else if (type.equals("Mouse")) {
            toy = new Mouse();

        }else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TOY_TYPE);
        }
        this.toys.buyToy(toy); // купувам toy

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = this.toys.findFirst(toyType); // взимам играчката от списъка с играчките

        if (toy == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_TOY_FOUND, toyType));
        }
         // купувам играчката за къщата --> buyToy
        House house = getHouseByName(houseName);
        house.buyToy(toy);
        // премахвам играчката от toyRepository
        this.toys.removeToy(toy);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    private House getHouseByName(String houseName) { // връща къщата по даденото име
        return this.houses.stream().filter(house -> house.getName().equals(houseName))
                .findFirst().get();
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {

         // създавам котка по тип --> "ShorthairCat", "LonghairCat"
         Cat cat;
             switch (catType){
                 case "ShorthairCat":
                     cat = new ShorthairCat(catName, catBreed, price);
                     break;

                 case "LonghairCat":
                     cat = new LonghairCat(catName, catBreed, price);
                     break;

                 default:
                     throw new IllegalArgumentException(ExceptionMessages.INVALID_CAT_TYPE);
             }

        House house = getHouseByName(houseName);// намираме къщата с даденото име


        boolean checkShort = catType.startsWith("Short") && house.getClass().getSimpleName().startsWith("Short");
        boolean checkLong = catType.startsWith("Long") && house.getClass().getSimpleName().startsWith("Long");

          if (checkShort || checkLong) { // котката може да влезе в къщата
              house.addCat(cat); // добавяме котката в къщата

          }else {
              return ConstantMessages.UNSUITABLE_HOUSE; // котката не може да влезе в къщата
          }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
    }

    @Override
    public String feedingCat(String houseName) {

        // взима къщата с име houseName
        House house = getHouseByName(houseName);
        house.feeding(); // преминава през всички котки (храни ги)

        return String.format(ConstantMessages.FEEDING_CAT, house.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {

        // взимам къщата с даденото име -- Calculates the value of the House with the given name
        House house = getHouseByName(houseName);

        // It is calculated by the sum of all Cat’s and Toy’s prices in the House
        double priceToys = house.getToys().stream().mapToDouble(Toy::getPrice).sum(); // сума от всички играчки
        double priceCats = house.getCats().stream().mapToDouble(Cat::getPrice).sum(); // сума от всички котки
        double priceAll = priceCats + priceToys; // обща сума от играчки и котки в къщата

        return String.format(ConstantMessages.VALUE_HOUSE, houseName, priceAll);
    }

    @Override
    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        for (House house: this.houses) {
            builder.append(house.getStatistics()).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
