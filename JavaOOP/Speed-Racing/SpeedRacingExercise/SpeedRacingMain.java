package SpeedRacingExercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class SpeedRacingMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String model = tokens[0];
            double fuel = Double.parseDouble(tokens[1]);
            double consumption = Double.parseDouble(tokens[2]);

            Car car = new Car(model, fuel, consumption  );
            cars.put(model, car);
        }
        String input = scan.nextLine();
        while (!input.equals("End")){
            String[] commands = input.split("\\s+");
            String model = commands[1];
            int distanceToDrive = Integer.parseInt(commands[2]);
            Car carToDrive = cars.get(model);
            if (!carToDrive.drive(distanceToDrive)){
                System.out.println("Insufficient fuel for the drive");
            }
            input = scan.nextLine();
        }
        for (Car car : cars.values()){
            System.out.println(car.toString());
        }
    }
}
