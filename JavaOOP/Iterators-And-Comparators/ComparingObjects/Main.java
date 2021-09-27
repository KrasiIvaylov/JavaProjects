package ComparingObjects;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Person> people = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("END")){

            String[] tokens = input.split("\\s+");

            Person p = new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            people.add(p);

            input = scanner.nextLine();
        }

        int index = Integer.parseInt(scanner.nextLine());

        int equal = 0;

        Person p = people.get(index - 1);

        for (Person person : people) {
            if(person.compareTo(p) == 0){
                equal++;
            }
        }

        if(equal == 1){
            System.out.println("No matches");
        }else{
            System.out.println(equal + " " + (people.size() - equal) + " " + people.size());
        }
    }
}
