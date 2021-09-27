package Car_Info;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        while (n-- > 0){
          String[] tokens =  scan.nextLine().split("\\s+");
          Car car = new Car();
          car.setBrand(tokens[0]);
          car.setModel(tokens[1]);
          car.setHorsePower(Integer.parseInt(tokens[2]));

            System.out.println(car.carInfo());
        }
    }
}
