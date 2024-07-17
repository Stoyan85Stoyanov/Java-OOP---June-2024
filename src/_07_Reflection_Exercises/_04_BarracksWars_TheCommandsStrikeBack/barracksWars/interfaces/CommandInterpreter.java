package _07_Reflection_Exercises._04_BarracksWars_TheCommandsStrikeBack.barracksWars.interfaces;


public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
