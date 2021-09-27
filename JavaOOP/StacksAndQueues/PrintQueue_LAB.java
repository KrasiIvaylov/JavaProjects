package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrintQueue_LAB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        String task = scan.nextLine();
        while (!task.equals("print")){
            if (task.equals("cancel")){
                if (printerQueue.isEmpty()){
                    System.out.println("Printer is on standby");
                }else{
                    System.out.println("Canceled " + printerQueue.poll());
                }
            }else{
                printerQueue.offer(task);
            }

            task = scan.nextLine();
        }
        while (!printerQueue.isEmpty()){
            System.out.println(printerQueue.poll());
        }
    }
}
