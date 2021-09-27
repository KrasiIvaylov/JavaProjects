package barracksWarsUpgraded.core.commands;

import barracksWarsUpgraded.interfaces.Executable;
import barracksWarsUpgraded.interfaces.Repository;
import barracksWarsUpgraded.interfaces.UnitFactory;

public abstract class Command implements Executable {
    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    protected Command(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    public Repository getRepository() {
        return repository;
    }

    public UnitFactory getUnitFactory() {
        return unitFactory;
    }

    public String[] getData() {
        return data;
    }
}
