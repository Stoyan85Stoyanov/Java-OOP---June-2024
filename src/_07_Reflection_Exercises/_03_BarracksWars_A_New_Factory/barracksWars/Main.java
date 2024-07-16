package _07_Reflection_Exercises._03_BarracksWars_A_New_Factory.barracksWars;

import _07_Reflection_Exercises._03_BarracksWars_A_New_Factory.barracksWars.interfaces.Repository;
import _07_Reflection_Exercises._03_BarracksWars_A_New_Factory.barracksWars.interfaces.Runnable;
import _07_Reflection_Exercises._03_BarracksWars_A_New_Factory.barracksWars.interfaces.UnitFactory;
import _07_Reflection_Exercises._03_BarracksWars_A_New_Factory.barracksWars.core.Engine;
import _07_Reflection_Exercises._03_BarracksWars_A_New_Factory.barracksWars.core.factories.UnitFactoryImpl;
import _07_Reflection_Exercises._03_BarracksWars_A_New_Factory.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
