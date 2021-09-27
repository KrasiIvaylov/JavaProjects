package StrategyPattern;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person f, Person s) {
        int result = f.getName().length() - s.getName().length();

        if(result == 0){
            result = f.getName().toLowerCase().charAt(0) - s.getName().toLowerCase().charAt(0);
        }

        return result;
    }
}