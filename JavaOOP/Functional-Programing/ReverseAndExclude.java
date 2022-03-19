import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        int n = Integer.parseInt(scan.nextLine());
        Predicate<Integer> predicate = number -> number % n == 0;
        Consumer<List<Integer>> printList = list -> list.forEach(e -> System.out.print( e + " "));
        numbers.removeIf(predicate);
        Collections.reverse(numbers);
        printList.accept(numbers);
    }
}
