package _07_Reflection_Exercises._04_BarracksWars_TheCommandsStrikeBack.barracksWars;

import _07_Reflection_Exercises._04_BarracksWars_TheCommandsStrikeBack.barracksWars.interfaces.Repository;
import _07_Reflection_Exercises._04_BarracksWars_TheCommandsStrikeBack.barracksWars.interfaces.Runnable;
import _07_Reflection_Exercises._04_BarracksWars_TheCommandsStrikeBack.barracksWars.interfaces.UnitFactory;
import _07_Reflection_Exercises._04_BarracksWars_TheCommandsStrikeBack.barracksWars.core.Engine;
import _07_Reflection_Exercises._04_BarracksWars_TheCommandsStrikeBack.barracksWars.core.factories.UnitFactoryImpl;
import _07_Reflection_Exercises._04_BarracksWars_TheCommandsStrikeBack.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
