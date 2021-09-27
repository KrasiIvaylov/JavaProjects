package GenericCountMethodDouble;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int n = Integer.parseInt(scan.nextLine());

        Box<Double> box = new Box();

        for (int i = 0; i < n; i++) {
            double text = Double.parseDouble(scan.nextLine());
            box.add(text);
        }
        double elementForCompare = Double.parseDouble(scan.nextLine());
        int countGreater = box.countGreaterThan(elementForCompare);
        System.out.println(countGreater);
    }
}
