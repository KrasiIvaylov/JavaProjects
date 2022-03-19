import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedList linkedList = new LinkedList();

        String input = scan.nextLine();
        while (!input.equals("stop")){
            try {
                int num = Integer.parseInt(input);
                linkedList.addFirst(num);
            }catch (NumberFormatException  exception ) {
                System.out.println("Please Enter Integer Number");
            }

            input = scan.nextLine();

        }

        linkedList.forEach(System.out::println);
    }
}
