package _07_Reflection_Exercises._04_BarracksWars_TheCommandsStrikeBack.barracksWars.interfaces;


public interface Repository {

	void addUnit(Unit unit);

	String getStatistics();

	void removeUnit(String unitType);
}
