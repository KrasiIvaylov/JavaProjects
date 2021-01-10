package ClassBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double length = Double.parseDouble(scan.nextLine());
        double width = Double.parseDouble(scan.nextLine());
        double height = Double.parseDouble(scan.nextLine());

        try {
            Box box = new Box(length, width, height);
            System.out.printf("Surface Area - %.2f%n" +
                    "Lateral Surface Area - %.2f%n" +
                    "Volume – %.2f%n",
                    box.calculateSurfaceArea(),
                    box.calculateLateralSurfaceArea(),
                    box.calculateVolume());
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
