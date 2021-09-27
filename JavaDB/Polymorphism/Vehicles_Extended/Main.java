package Vehicles_Extended;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();

        vehicleMap.put("Car", createVehicle(scan.nextLine().split("\\s+")));
        vehicleMap.put("Truck", createVehicle(scan.nextLine().split("\\s+")));

        Bus bus = createBus(scan.nextLine().split("\\s+"));

        vehicleMap.put("Bus", bus);

        int commandsCount = Integer.parseInt(scan.nextLine());

        while (commandsCount-- > 0) {
            String command = scan.nextLine();

            String[] params = command.split("\\s+");

            double argument = Double.parseDouble(params[2]);

            if (command.contains("Drive") && command.contains("Bus")) {
                System.out.println(bus.driveWithPassengers(argument));
            }else if (command.contains("Drive")) {
                System.out.println(vehicleMap.get(params[1]).drive(argument));
            } else {
                try {
                    vehicleMap.get(params[1]).refuel(argument);
                } catch (IllegalArgumentException exception) {
                    System.out.println(exception.getMessage());
                }
            }
        }
        for (Vehicle vehicle : vehicleMap.values()) {
            System.out.println(vehicle.toString());
        }
    }

    private static Bus createBus(String[] tokens) {

        return new Bus(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]),
                Double.parseDouble(tokens[3]));
    }

    private static Vehicle createVehicle(String[] tokens) {
        switch (tokens[0]) {
            case "Car":
                return new Car(Double.parseDouble(tokens[1]),
                        Double.parseDouble(tokens[2]),
                        Double.parseDouble(tokens[3]));
            case "Truck":
                return new Truck(Double.parseDouble(tokens[1]),
                        Double.parseDouble(tokens[2]),
                        Double.parseDouble(tokens[3]));
            case "Bus":
                return createBus(tokens);
            default:
                throw new IllegalArgumentException
                        ("Unknown Vehicle type for " + tokens[0]);
        }
    }
}
