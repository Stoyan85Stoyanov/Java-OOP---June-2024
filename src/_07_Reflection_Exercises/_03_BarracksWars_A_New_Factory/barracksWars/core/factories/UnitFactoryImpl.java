package _07_Reflection_Exercises._03_BarracksWars_A_New_Factory.barracksWars.core.factories;

import _07_Reflection_Exercises._03_BarracksWars_A_New_Factory.barracksWars.interfaces.Unit;
import _07_Reflection_Exercises._03_BarracksWars_A_New_Factory.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {


		try {
			Class unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor<Unit> constructor = unitClass.getDeclaredConstructor();
			return constructor.newInstance();

		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException |
				 NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
	}
}
