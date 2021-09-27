package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PositionOF {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
           matrix[row] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
       int number = Integer.parseInt(scan.nextLine());
        boolean isFound = false;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
               int currentNumber = matrix[row][col];
               if (currentNumber == number){
                   System.out.println(row + " " + col);
                   isFound = true;
               }
            }
        }
        if (!isFound){
            System.out.println("not found");
        }
    }

    private static boolean compareMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length){
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            int[] firstArr = firstMatrix[row];
            int[] secondArr = secondMatrix[row];
            if (firstArr.length != secondArr.length){
                return false;
            }
            for (int col = 0; col < firstArr.length; col++) {
                if (firstArr[col] != secondArr[col]){
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] readMatrix(Scanner scan){
        String[] tokens = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);
        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            String[] line = scan.nextLine()
                    .split("\\s+");
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = Integer.parseInt(line[c]);
            }
        }
        return matrix;
    }
}
