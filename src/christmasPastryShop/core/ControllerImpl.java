package christmasPastryShop.core;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.common.OutputMessages;
import christmasPastryShop.common.enums.BoothType;
import christmasPastryShop.common.enums.CocktailType;
import christmasPastryShop.common.enums.DelicacyType;
import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.OpenBooth;
import christmasPastryShop.entities.booths.PrivateBooth;
import christmasPastryShop.entities.cocktails.Hibernation;
import christmasPastryShop.entities.cocktails.MulledWine;
import christmasPastryShop.entities.delicacies.Gingerbread;
import christmasPastryShop.entities.delicacies.Stolen;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

public class ControllerImpl implements Controller {
    private final DelicacyRepository<Delicacy> delicacyRepository;
    private final CocktailRepository<Cocktail> cocktailRepository;
    private final BoothRepository<Booth> boothRepository;
    private double totalPriceIncome;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
        this.totalPriceIncome = 0;

    }


    @Override
    public String addDelicacy(String type, String name, double price) {
       // Създава деликатес с правилния вид.
        // Ако деликатесът е създаден успешно, се връща

        Delicacy delicacy = delicacyRepository.getByName(name);

        if (delicacy == null) {
            DelicacyType foodType = DelicacyType.valueOf(type);

            switch (foodType) {
                case Gingerbread:
                    delicacy = new Gingerbread(name, price);
                    break;

                case Stolen:
                    delicacy = new Stolen(name, price);
                    break;
            }
        } else {  // Ако деликатес с даденото име вече съществува в хранилището за деликатеси, хвърлете
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, delicacy.getClass().getSimpleName(), name));

        }
        delicacyRepository.add(delicacy);
        return String.format(OutputMessages.DELICACY_ADDED, name, type);

    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        // Създава коктейл с правилния вид.
        // Ако коктейлът е създаден успешно, се връща

        Cocktail cocktail = cocktailRepository.getByName(name);

        if (cocktail == null) {
            CocktailType cocktailType = CocktailType.valueOf(type);

            switch (cocktailType) {
                case MulledWine:
                    cocktail = new MulledWine(name, size, brand);
                    break;

                case Hibernation:
                    cocktail = new Hibernation(name, size, brand);
                    break;
            }
        } else { // Ако коктейл с даденото име вече съществува в хранилището за коктейли, хвърлете
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, cocktail.getClass().getSimpleName(), cocktail.getName()));
        }
        cocktailRepository.add(cocktail);
        return String.format(OutputMessages.COCKTAIL_ADDED, name, brand);
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
         // Създава кабина с правилния тип и се връща

        Booth booth = boothRepository.getByNumber(boothNumber);
        if (booth == null) {
            BoothType tableType = BoothType.valueOf(type);

            switch (tableType) {
                case OpenBooth:
                    booth = new OpenBooth(boothNumber, capacity);
                    break;
                case PrivateBooth:
                    booth = new PrivateBooth(boothNumber, capacity);
                    break;
            }
        } else {  // Ако щанд с даденото име вече съществува в хранилището на щанда, хвърлете
            throw new IllegalArgumentException(String.format(ExceptionMessages.BOOTH_EXIST, boothNumber));
        }
        boothRepository.add(booth);
        return String.format(OutputMessages.BOOTH_ADDED, boothNumber);

    }

    @Override
    public String reserveBooth(int numberOfPeople) {
         // Намира сепаре, което не е запазено и капацитетът му е достатъчен за предвидения брой хора.
        // Ако няма такъв щанд се връща

        for (Booth booth : boothRepository.getAll()) {
            if (!booth.isReserved() && booth.getCapacity() >= numberOfPeople) {
                booth.reserve(numberOfPeople);
                return String.format(OutputMessages.BOOTH_RESERVED, booth.getBoothNumber(), numberOfPeople);
            }
        }
        // В другия случай запазва сепарето и се връща
        return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
    }

    @Override
    public String leaveBooth(int boothNumber) {
        // Намира кабината със същия номер на кабината.
        // Получава сметката за този щанд, изчиства я и добавя сумата към общия доход на магазина.
        // Сметката не са само поръчките, но и резервацията за брой хора

        Booth booth = boothRepository.getByNumber(boothNumber);
        double bill = booth.getBill();
        this.totalPriceIncome += bill;
        booth.clear();
        return String.format(OutputMessages.BILL, boothNumber, bill);

    }

    @Override
    public String getIncome() {
         // Връща общия приход на сладкарницата за всички изпълнени сметки
        return String.format(OutputMessages.TOTAL_INCOME, this.totalPriceIncome);
    }


}
