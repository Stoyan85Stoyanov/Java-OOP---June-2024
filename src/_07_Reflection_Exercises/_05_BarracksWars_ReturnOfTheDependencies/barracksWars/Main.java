package _07_Reflection_Exercises._05_BarracksWars_ReturnOfTheDependencies.barracksWars;

import _07_Reflection_Exercises._05_BarracksWars_ReturnOfTheDependencies.barracksWars.interfaces.Repository;
import _07_Reflection_Exercises._05_BarracksWars_ReturnOfTheDependencies.barracksWars.interfaces.Runnable;
import _07_Reflection_Exercises._05_BarracksWars_ReturnOfTheDependencies.barracksWars.interfaces.UnitFactory;
import _07_Reflection_Exercises._05_BarracksWars_ReturnOfTheDependencies.barracksWars.core.Engine;
import _07_Reflection_Exercises._05_BarracksWars_ReturnOfTheDependencies.barracksWars.core.factories.UnitFactoryImpl;
import _07_Reflection_Exercises._05_BarracksWars_ReturnOfTheDependencies.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {

        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
