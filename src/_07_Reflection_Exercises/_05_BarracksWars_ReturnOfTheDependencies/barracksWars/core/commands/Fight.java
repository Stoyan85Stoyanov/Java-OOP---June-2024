package _07_Reflection_Exercises._05_BarracksWars_ReturnOfTheDependencies.barracksWars.core.commands;

import _07_Reflection_Exercises._05_BarracksWars_ReturnOfTheDependencies.barracksWars.interfaces.Repository;
import _07_Reflection_Exercises._05_BarracksWars_ReturnOfTheDependencies.barracksWars.interfaces.UnitFactory;

public class Fight extends Command{

    public Fight(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
