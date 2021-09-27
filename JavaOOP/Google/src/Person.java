import java.util.ArrayList;
import java.util.List;

public class Person {
    private Company company;
    private Car car;
    private List<Pokemon> pokemons;
    private List<Parents> parents;
    private List<Children> children;

    public Person() {
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void setPersonCompany(Company company) {
        this.company = company;
    }

    public void setPersonCar(Car car) {
        this.car = car;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public List<Parents> getParents() {
        return this.parents;
    }

    public List<Children> getChildren() {
        return this.children;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append("Company:\n");
        if (this.company != null) {
            output.append(this.company.toString()).append("\n");
        }
        output.append("Car:\n");
        if (this.car != null) {
            output.append(this.car.toString()).append("\n");
        }
        output.append("Pokemon:\n");
        if (this.pokemons.size() != 0) {
            this.pokemons.forEach(p -> output.append(p.toString()).append("\n"));
        }
        output.append("Parents:\n");
        if (this.parents.size() != 0) {
            this.parents.forEach(p -> output.append(p.toString()).append("\n"));
        }
        output.append("Children:\n");
        if (this.children.size() != 0) {
            this.children.forEach(p -> output.append(p.toString()).append("\n"));
        }

        return output.toString();
    }
}
