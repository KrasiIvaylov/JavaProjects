package barracksWarsUpgraded.interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
