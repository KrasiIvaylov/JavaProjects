package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> inputElements = Arrays.stream(scanner.nextLine().split("\\s+")).skip(1)
                .collect(Collectors.toCollection(ArrayList::new));

        ListIterator listlyIterator = new ListIterator(inputElements);

        String command = scanner.nextLine();

        while (!command.equals("END")){
            switch (command){
                case "Move":
                    System.out.println(listlyIterator.move());
                    break;
                case "Print":
                    System.out.println(listlyIterator.print());
                    break;
                case "HasNext":
                    System.out.println(listlyIterator.hasNext());
                    break;
                case "PrintAll":
                    for (String s : listlyIterator) {
                        System.out.print(s + " ");
                    }
                    System.out.println();
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
