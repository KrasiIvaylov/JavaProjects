import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Problem01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        ArrayDeque<Integer> threads = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split(", ")).forEach(e -> tasks.push(Integer.parseInt(e)));
        Arrays.stream(scan.nextLine().split("\\s+")).forEach(e -> threads.offer(Integer.parseInt(e)));
        int taskToKill = Integer.parseInt(scan.nextLine());

        //int sum = tasks.pollLast() + threads.poll();
        while (!tasks.isEmpty() && !threads.isEmpty()) {
            int n = tasks.peek();
            int m = threads.peek();
            if (tasks.peek() == taskToKill) {
                System.out.printf("Thread with value %d killed task %d%n",threads.peek(), taskToKill);
                break;
            }
            if (threads.peek() >= tasks.peek()) {
                tasks.pop();
                threads.poll();
            } else {
                threads.poll();
            }

        }

        if (!threads.isEmpty() && !tasks.isEmpty()){
            System.out.println(threads.toString().replaceAll("[\\[\\],]", ""));
        }

    }
}
