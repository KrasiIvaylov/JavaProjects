package Multiple_Inheritance;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Dog dog = new Dog();
        Puppy puppy = new Puppy();
        dog.eat();
        dog.bark();
        puppy.weep();
    }
}
