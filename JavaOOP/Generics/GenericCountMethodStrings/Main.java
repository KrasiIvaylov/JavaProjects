package GenericCountMethodStrings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int n = Integer.parseInt(scan.nextLine());

        Box<String> box = new Box();

        for (int i = 0; i < n; i++) {
            String text = scan.nextLine();
            box.add(text);
        }
        String elementForCompare = scan.nextLine();
        int countGreater = box.countGreaterThan(elementForCompare);
        System.out.println(countGreater);
    }
}
