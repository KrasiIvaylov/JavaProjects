import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int maxLength = Integer.parseInt(scan.nextLine());
        String[] names = scan.nextLine().split("\\s+");
        Predicate<String> isValidLength = name -> name.length() <= maxLength;
        Arrays.stream(names).filter(isValidLength).forEach(System.out::println);
    }
}
