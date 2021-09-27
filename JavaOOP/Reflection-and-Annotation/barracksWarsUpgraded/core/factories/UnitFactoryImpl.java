package barracksWarsUpgraded.core.factories;

import barracksWarsUpgraded.interfaces.Unit;
import barracksWarsUpgraded.interfaces.UnitFactory;
import barracksWarsUpgraded.models.units.AbstractUnit;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException {
		Unit unit;
		try {
			Class<? extends AbstractUnit> clazz =
					(Class<? extends AbstractUnit>) 	Class.forName(UNITS_PACKAGE_NAME + unitType);
			unit = (Unit) clazz.getDeclaredConstructor().newInstance();
		} catch (ClassNotFoundException
				| NoSuchMethodException
				| InstantiationException
				| IllegalAccessException
				| InvocationTargetException e) {
			throw new IllegalStateException(e);
		}
		return unit;
	}
}
