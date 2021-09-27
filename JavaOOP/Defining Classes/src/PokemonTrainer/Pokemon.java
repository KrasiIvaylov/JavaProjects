package PokemonTrainer;

public class Pokemon {
    private String name;
    private String element;
    private int health;

    public String getName() {
        return name;
    }

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }


    public String getElement() {
        return element;
    }

    public void lowerHealth() {
        this.health -= 10;
    }

    public int getHealth() {
        return health;
    }
}

