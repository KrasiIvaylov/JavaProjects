import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SmartArray smart = new SmartArray();

        for (int i = 0; i < 1024; i++) {
            smart.add(i + 1);
        }
        for (int i = 0; i < 1023; i++) {
            smart.remove(1023 -i);
        }

        smart.forEach(System.out::println);
    }
}
