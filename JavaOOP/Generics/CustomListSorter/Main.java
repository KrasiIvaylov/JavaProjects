package CustomListSorter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();
        CustomList<String> list = new CustomList<String>();

        while (!command.equals("END")) {
            String[] tokens = command.split("\\s+");
            String commandWord = tokens[0];
            switch (commandWord) {
                case "Add":
                    String element = tokens[1];
                    list.add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(tokens[1]);
                    list.remove(index);
                    break;
                case "Contains":
                    String searched = tokens[1];
                    System.out.println(list.contains(searched));
                    break;
                case "Swap":
                    int first = Integer.parseInt(tokens[1]);
                    int second = Integer.parseInt(tokens[2]);
                    list.swap(first, second);
                    break;
                case "Greater":
                    String greater = tokens[1];
                    System.out.println(list.countGreaterThan(greater));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    System.out.println(list);
                    break;
                case "Sort":
                    Sorter.sort(list);
                    break;
            }
            command = scan.nextLine();
        }
    }
}
