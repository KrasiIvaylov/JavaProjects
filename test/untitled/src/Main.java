import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int one = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        double two = Double.parseDouble(scanner.nextLine());

        double result = 0;

        switch (operator) {
            case "+":
                result = one + two;
                break;
            case "-":
                result = one - two;
                break;
            case "*":
                result = one * two;
                break;
            case "/":
                result = one / two;
                break;
        }
        System.out.printf("%.2f", result);

    }
}
