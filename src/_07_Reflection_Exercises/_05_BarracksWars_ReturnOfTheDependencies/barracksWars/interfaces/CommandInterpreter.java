package _07_Reflection_Exercises._05_BarracksWars_ReturnOfTheDependencies.barracksWars.interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
