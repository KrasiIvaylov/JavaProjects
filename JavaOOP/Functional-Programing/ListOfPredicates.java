import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int n = Integer.parseInt(scan.nextLine());
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        BiFunction<List<Integer>, Integer, Boolean> predicate = ((list, number) -> {
            for (Integer num : list){
                if (number % num != 0){
                    return false;
                }
            }
            return true;
        });
        for (int number = 1; number <= n; number++) {
            if (predicate.apply(numbers, number)){
                System.out.print(number + " ");
            }
        }
    }
}
