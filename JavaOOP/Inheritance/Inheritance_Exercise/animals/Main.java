package animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String typeAnimal = scan.nextLine();
        while (!typeAnimal.equals("Beast!")) {
            String[] animalData = scan.nextLine().split("\\s+");
            String name = animalData[0];
            int age = Integer.parseInt(animalData[1]);

            
            try {
            if (age < 0) {
                throw new IllegalArgumentException("Invalid input!");
            }
            }catch (IllegalArgumentException e){
                    System.out.println("Invalid input!");
                    typeAnimal = scan.nextLine();
                    continue;
                }

            if (!animalData[2].equals("Male") && !animalData[2].equals("Female")){
                throw new IllegalArgumentException("Invalid gender!");
            }
            Gender gender = Gender.MALE;
            if (animalData[2].equals("Female")){
                gender = Gender.FEMALE;
            }
            switch (typeAnimal) {
                case "Frog":
                    Frog frog = new Frog(name, age, gender);
                    System.out.println(frog.toString());
                    break;
                case "Dog":
                    Dog dog = new Dog(name, age, gender);
                    System.out.println(dog.toString());
                    break;
                case "Cat":
                    Cat cat  = new Cat(name, age , gender);
                    System.out.println(cat.toString());
                    break;
                case "Kittens":
                    Kitten kitten = new Kitten(name, age);
                    System.out.println(kitten.toString());
                    break;
                case "Tomcat":
                    Tomcat tomcat = new Tomcat(name, age);
                    System.out.println(tomcat.toString());
                    break;
            }

            typeAnimal = scan.nextLine();
        }
    }
}
