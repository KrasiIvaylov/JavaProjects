package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[matrixSize][matrixSize];
        fillSquareMatrix(scan,matrix, matrixSize, matrixSize);

        int sumD1 = 0;
        int sumD2 = 0;

        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                int number = matrix[row][col];
                if (row == col){
                    sumD1 += number;
                }
                if (col == matrixSize - row - 1){
                    sumD2 += number;
                }
            }
        }
        System.out.println(Math.abs(sumD1 - sumD2));


    }
    public static void fillSquareMatrix(Scanner scan, int[][] matrix, int rows, int cols) {
        /*
        ПЪЛНЕНЕ НА КВАДРАТНА МАТРИЦА
         */
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
    }
    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
