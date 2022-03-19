package barracksWarsUpgraded;

import barracksWarsUpgraded.interfaces.Repository;
import barracksWarsUpgraded.interfaces.Runnable;
import barracksWarsUpgraded.interfaces.UnitFactory;
import barracksWarsUpgraded.core.Engine;
import barracksWarsUpgraded.core.factories.UnitFactoryImpl;
import barracksWarsUpgraded.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
