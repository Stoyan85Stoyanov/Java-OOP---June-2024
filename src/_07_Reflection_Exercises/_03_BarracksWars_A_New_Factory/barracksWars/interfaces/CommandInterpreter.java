package _07_Reflection_Exercises._03_BarracksWars_A_New_Factory.barracksWars.interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
