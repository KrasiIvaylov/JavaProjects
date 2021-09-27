import java.util.Scanner;

public class Problem02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

      String[] input = scan.nextLine().split("\\s+");
      int n = Integer.parseInt(input[0]);
      int m = Integer.parseInt(input[1]);
      int[][] matrix = new int[n][m];

      String command = scan.nextLine();

      while (!command.equals("Bloom Bloom Plow")){
          String[] tokens = command.split("\\s+");
          int row = Integer.parseInt(tokens[0]);
          int col = Integer.parseInt(tokens[1]);

          if (row >= n || col >= m || row < 0 || col < 0){
              System.out.println("Invalid coordinates.");
              command = scan.nextLine();
              continue;
          }
          for (int i = 0; i < n; i++) {
              matrix[i][col] += 1;
          }
          for (int i = 0; i < m; i++) {
              if (i != col){
                  matrix[row][i] += 1;
              }
          }
          command = scan.nextLine();
      }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
