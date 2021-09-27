package MultidimensionalArrays;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());
        char[][] first = readMatrix(scan, rows, cols);
        char[][] second = readMatrix(scan, rows, cols);

        char[][] output = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                output[row][col] =
                        first[row][col] == second[row][col]
                        ? first[row][col]
                        : '*';
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
               char symbol = output[row][col];
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }
    public static char[][] readMatrix(Scanner scan, int rows, int cols){
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] symbols = scan.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = symbols[col].charAt(0);
            }
        }
        return matrix;
    }
}
