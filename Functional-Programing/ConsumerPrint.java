import java.util.Arrays;
import java.util.Scanner;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Arrays.stream(scan.nextLine().split("\\s+"))
                .forEach(System.out::println);
    }
}
