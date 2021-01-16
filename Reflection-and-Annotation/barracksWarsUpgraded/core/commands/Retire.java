package barracksWarsUpgraded.core.commands;

import barracksWarsUpgraded.interfaces.Repository;
import barracksWarsUpgraded.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class Retire extends Command{
    public Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        String unitType = this.getData()[1];
        this.getRepository().removeUnit(unitType);


        return unitType + " retired!";
    }
}
