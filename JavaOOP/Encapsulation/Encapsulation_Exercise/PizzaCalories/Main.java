package PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String[] tokens = input.split("\\s+");

        try {

            Pizza pizza = new Pizza(tokens[1], Integer.parseInt(tokens[2]));
            tokens = scan.nextLine().split("\\s+");
            Dough dough = new Dough(tokens[1], tokens[2], Double.parseDouble(tokens[3]));
            pizza.setDough(dough);

            input = scan.nextLine();
            while (!input.equals("END")) {
                tokens = input.split("\\s+");
                Topping topping = new Topping(tokens[1], Double.parseDouble(tokens[2]));
                pizza.addTopping(topping);

                input = scan.nextLine();
            }
            System.out.println(pizza.toString());
        }catch (IllegalArgumentException ex ){
            System.out.println(ex.getMessage());
        }
    }
}
