package StrategyPattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n =  Integer.parseInt(scanner.nextLine());

        TreeSet<Person> peopleByNames = new TreeSet<Person>(new PersonNameComparator());
        TreeSet<Person> peopleByAges = new TreeSet<Person>(new PersonAgeComparator());

        while (n-- > 0){
            String[] data = scanner.nextLine().split("\\s+");
            Person p = new Person(data[0], Integer.parseInt(data[1]));
            peopleByAges.add(p);
            peopleByNames.add(p);
        }

        for (Person person : peopleByNames) {
            System.out.println(person);
        }

        for (Person person : peopleByAges) {
            System.out.println(person);
        }
    }
}
