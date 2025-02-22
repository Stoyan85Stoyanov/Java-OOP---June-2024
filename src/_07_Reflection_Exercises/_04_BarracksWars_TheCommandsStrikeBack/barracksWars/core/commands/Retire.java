package _07_Reflection_Exercises._04_BarracksWars_TheCommandsStrikeBack.barracksWars.core.commands;


import _07_Reflection_Exercises._04_BarracksWars_TheCommandsStrikeBack.barracksWars.interfaces.Repository;
import _07_Reflection_Exercises._04_BarracksWars_TheCommandsStrikeBack.barracksWars.interfaces.UnitFactory;

public class Retire extends Command {

    public Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {

        this.getRepository().removeUnit(this.getData()[1]);
        return this.getData()[1] + " retired!";
    }
}
