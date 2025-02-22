package _07_Reflection_Exercises._04_BarracksWars_TheCommandsStrikeBack.barracksWars.core.commands;


import _07_Reflection_Exercises._04_BarracksWars_TheCommandsStrikeBack.barracksWars.interfaces.Executable;
import _07_Reflection_Exercises._04_BarracksWars_TheCommandsStrikeBack.barracksWars.interfaces.Repository;
import _07_Reflection_Exercises._04_BarracksWars_TheCommandsStrikeBack.barracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable {

    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    protected Command(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    protected String[] getData() {
        return data;
    }

    protected Repository getRepository() {
        return repository;
    }

    protected UnitFactory getUnitFactory() {
        return unitFactory;
    }
}
