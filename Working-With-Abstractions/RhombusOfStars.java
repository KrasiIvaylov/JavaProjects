import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        for (int r = 1; r <= n; r++) {
            for (int j = 0; j < n - r; j++) {
                System.out.print(" ");
            }
            for (int i = 0; i < r; i++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        //second half
        for (int r = 1; r <= n - 1; r++) {
            for (int i = 0; i < r; i++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n - r; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
