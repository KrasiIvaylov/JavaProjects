package Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");

        Vehicle car = new Car(Double.parseDouble(input[1]), Double.parseDouble(input[2]));

        input = scan.nextLine().split("\\s+");

        Vehicle truck = new Truck(Double.parseDouble(input[1]), Double.parseDouble(input[2]));

        int commandsCount = Integer.parseInt(scan.nextLine());

        while (commandsCount-- > 0){
            String command = scan.nextLine();

            String[] params = command.split("\\s+");

            double argument = Double.parseDouble(params[2]);

            if (command.contains("Drive")){
                if (params[1].equals("Car")){
                    System.out.println(car.drive(argument));
                }else{
                    System.out.println(truck.drive(argument));
                }
            }else {
                if (params[1].equals("Car")){
                    car.refuel(argument);
                }else{
                    truck.refuel(argument);
                }

            }
        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
    }
}
