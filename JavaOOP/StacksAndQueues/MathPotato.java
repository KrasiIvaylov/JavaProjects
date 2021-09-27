package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] kids = scan.nextLine().split("\\s+");
        ArrayDeque<String> queue = new ArrayDeque<>(Arrays.asList(kids));
        int n = Integer.parseInt(scan.nextLine());
        int round = 0;

        while (queue.size() > 1){
            boolean isPrime = true;
            round++;
            if (round == 1){
                isPrime = false;
            }
            for (int i = 2; i < round; i++) {
                if (round % i == 0){
                    isPrime = false;
                     break;
                }
            }
            for (int i = 0; i < n; i++) {
                if (i == n - 1){
                    if (isPrime){
                        System.out.println("Prime " + queue.peek());
                    }else{
                        System.out.println("Removed " + queue.poll());
                    }
                }else{
                    String curr = queue.poll();
                    queue.offer(curr);
                }
            }
        }
        System.out.printf("Last is %s", queue.poll());
    }
}
