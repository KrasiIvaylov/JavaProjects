import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedReader console =
                new BufferedReader(new InputStreamReader(System.in));

        String input = console.readLine();
        Map<String, Person> people = new HashMap<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            Person person = new Person();

            people.putIfAbsent(name, person);

            switch (tokens[1]) {
                case "company":
                    Company company =  new Company(tokens[2], tokens[3], Double.parseDouble(tokens[4]));
                    people.get(name).setPersonCompany(company);
                    break;
                case "car":
                    Car car = new Car(tokens[2], tokens[3]);
                    people.get(name).setPersonCar(car);
                    break;
                case "pokemon":
                    Pokemon pokemon = new Pokemon(tokens[2], tokens[3]);
                    people.get(name).getPokemons().add(pokemon);
                    break;
                case "parents":
                    Parents parents = new Parents(tokens[2], tokens[3]);
                    people.get(name).getParents().add(parents);
                    break;
                case "children":
                    Children children = new Children(tokens[2], tokens[3]);
                    people.get(name).getChildren().add(children);
                    break;
            }
            input = console.readLine();
        }
        String currentPerson = console.readLine();
        console.close();

        System.out.println(currentPerson);
        people.forEach((key, value) -> {
            if (key.equals(currentPerson)){
                System.out.println(value.toString());
            }
        });
    }
}
