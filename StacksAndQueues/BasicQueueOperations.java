package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        String[] firstLine = scan.nextLine().split("\\s+");

        int n = Integer.parseInt(firstLine[0]);
        int s = Integer.parseInt(firstLine[1]);
        int x = Integer.parseInt(firstLine[2]);

        String[] secondLine = scan.nextLine().split("\\s+");
        for (int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(secondLine[i]));
        }
        for (int j = 0; j < s; j++) {
            queue.poll();
        }
        if (queue.isEmpty()) {
            System.out.println(0);
        } else {
            if (queue.contains(x)) {
                System.out.println("true");
            } else {
                System.out.println(queue.stream().mapToInt(e -> e).min().getAsInt());
            }
        }
    }
}
