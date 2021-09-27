package RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console =
                new BufferedReader(new InputStreamReader(System.in));

        Map<String, Car> cars = new LinkedHashMap<>();
        int n = Integer.parseInt(console.readLine());

        while (n-- > 0) {
            String[] tokens = console.readLine().split("\\s+");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double tire1Pressure = Double.parseDouble(tokens[5]);
            int tire1Age = Integer.parseInt(tokens[6]);
            double tire2Pressure = Double.parseDouble(tokens[7]);
            int tire2Age = Integer.parseInt(tokens[8]);
            double tire3Pressure = Double.parseDouble(tokens[9]);
            int tire3Age = Integer.parseInt(tokens[10]);
            double tire4Pressure = Double.parseDouble(tokens[11]);
            int tire4Age = Integer.parseInt(tokens[12]);

            Tires tire = new Tires(tire1Pressure, tire1Age, tire2Pressure, tire2Age,
                    tire3Pressure, tire3Age, tire4Pressure, tire4Age);
            Car car = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType);

            cars.putIfAbsent(model, car);
            cars.get(model).getTires().add(tire);
        }
        String command = console.readLine();

        switch (command) {
            case "fragile":
                for (Car car : cars.values()) {
                    if (car.getType().equals(command) && car.isPressureLess()){
                        System.out.println(car.getModel());
                    }
                }
                break;
            case "flamable":
                for (Car car : cars.values()) {
                    if (car.getType().equals(command) && car.getPower() > 250){
                        System.out.println(car.getModel());
                    }
                }
                break;
        }
    }
}
