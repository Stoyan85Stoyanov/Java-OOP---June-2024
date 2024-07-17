package _07_Reflection_Exercises._05_BarracksWars_ReturnOfTheDependencies.barracksWars.interfaces;

public interface Repository {

	void addUnit(Unit unit);

	String getStatistics();

	void removeUnit(String unitType);
}
