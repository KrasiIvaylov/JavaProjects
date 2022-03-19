package barracksWarsUpgraded.core.commands;

import barracksWarsUpgraded.interfaces.Repository;
import barracksWarsUpgraded.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class Report extends Command {
    public Report(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        return getRepository().getStatistics();
    }
}
