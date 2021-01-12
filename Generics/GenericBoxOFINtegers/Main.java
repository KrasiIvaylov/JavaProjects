package GenericBoxOFINtegers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Box<Integer> box = new Box();
        for (int i = 0; i < n; i++) {
            Integer text = Integer.parseInt(scan.nextLine());
            box.add(text);
        }
        System.out.println(box);
    }
}
