package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] kids = scan.nextLine().split("\\s+");
        ArrayDeque<String> queue = new ArrayDeque<>();
        int n = Integer.parseInt(scan.nextLine());

        for (String child : kids) {
            queue.offer(child);
        }
         while (queue.size() > 1){
             for (int i = 1; i < n; i++) {
                 queue.offer(queue.poll());
                 System.out.println("Removed " + queue.poll());
             }
         }
        System.out.printf("Last is %s", queue.poll());
    }
}
