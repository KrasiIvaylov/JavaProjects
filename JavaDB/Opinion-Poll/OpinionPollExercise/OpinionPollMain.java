package OpinionPollExercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OpinionPollMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            if (age > 30) {
                people.add(new Person(name, age));
            }
        }
        people.sort(Comparator.comparing(Person::getName));
        for (Person person : people){
            System.out.println(person.toString());
        }
    }
}
