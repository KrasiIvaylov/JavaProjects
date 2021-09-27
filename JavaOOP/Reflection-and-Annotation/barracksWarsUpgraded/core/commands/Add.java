package barracksWarsUpgraded.core.commands;

import barracksWarsUpgraded.interfaces.Repository;
import barracksWarsUpgraded.interfaces.Unit;
import barracksWarsUpgraded.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class Add  extends Command{
    public Add(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        String unitType = getData()[1];
        Unit unitToAdd = getUnitFactory().createUnit(unitType);
        getRepository().addUnit(unitToAdd);
        return unitType + " added!";
    }
}
