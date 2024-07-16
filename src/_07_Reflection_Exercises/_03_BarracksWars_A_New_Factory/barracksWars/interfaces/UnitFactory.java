package _07_Reflection_Exercises._03_BarracksWars_A_New_Factory.barracksWars.interfaces;

import jdk.jshell.spi.ExecutionControl;

public interface UnitFactory {

    Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException;
}