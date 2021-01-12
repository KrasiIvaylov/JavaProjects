package GenericSwapMethddStrings;

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
        String[] indexes = scan.nextLine().split("\\s+");
        int firstIndex = Integer.parseInt(indexes[0]);
        int secondIndex = Integer.parseInt(indexes[1]);
        if (firstIndex < box.length() && secondIndex < box.length()) {
            box.swap(firstIndex, secondIndex);
        }else{
            throw new IndexOutOfBoundsException("Invalid Indexes!");
        }

        System.out.println(box);
    }
}
