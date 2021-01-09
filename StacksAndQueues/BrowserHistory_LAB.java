package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory_LAB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String navigation = scan.nextLine();
        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        String current = "";

        while (!navigation.equals("Home")) {
            if (navigation.equals("back")) {
                if (history.isEmpty()) {
                    System.out.println("no previous URLs");
                    navigation = scan.nextLine();
                    continue;
                } else {
                    current = history.pop();
                }
            }else if (navigation.equals("forward")) {
                if (queue.isEmpty()){
                    System.out.println("no next URLs");
                }
            }else{
                if (!current.isEmpty()) {
                    history.push(current);
                }
                current = navigation;
            }
            navigation = scan.nextLine();
            System.out.println(current);
        }
    }

}
