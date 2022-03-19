package MultidimensionalArraysExercise;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[size][size];
        int startNumber = 1;

        if (pattern.equals("A")){
            fillPatternA(size, matrix, startNumber);
        }else if (pattern.equals("B")){
            fillPatternB(size, matrix, startNumber);
        }
        printMatrix(matrix,size, size);
    }

    private static void fillPatternB(int size, int[][] matrix, int startNumber) {
        for (int col = 0; col < size; col++) {
            if (col % 2 == 0){
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = startNumber++;
                }
            }else{
                for (int row = size - 1; row >= 0; row--) {
                    matrix[row][col] = startNumber++;
                }
            }
        }
    }

    private static void fillPatternA(int size, int[][] matrix, int startNumber) {
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = startNumber++;
            }
        }
    }

    public static void printMatrix(int[][] matrix, int rows, int cols) {
        /*
        ПРИНТИРАНЕ НА МАТРИЦА
         */
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
