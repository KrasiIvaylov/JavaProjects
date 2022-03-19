import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        Consumer<List<Integer>> findIndex = list ->
                System.out.println(list.lastIndexOf(Collections.min(list)));
        findIndex.accept(numbers);
     }
}
