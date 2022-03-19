package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();
        ArrayDeque<String> numbers = new ArrayDeque<>();
        Arrays.stream(line.split("\\s+"))
                .forEach(numbers::push);
        while (!numbers.isEmpty()){
            System.out.print(numbers.pop() + " ");
        }
    }
}
