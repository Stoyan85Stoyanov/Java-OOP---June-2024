package _07_Reflection_Exercises._05_BarracksWars_ReturnOfTheDependencies.barracksWars.core.commands;

import _07_Reflection_Exercises._05_BarracksWars_ReturnOfTheDependencies.barracksWars.interfaces.Executable;
import _07_Reflection_Exercises._05_BarracksWars_ReturnOfTheDependencies.barracksWars.interfaces.Repository;
import _07_Reflection_Exercises._05_BarracksWars_ReturnOfTheDependencies.barracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable {

    private final String[] data;
    private final Repository repository;
    private final UnitFactory unitFactory;

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
