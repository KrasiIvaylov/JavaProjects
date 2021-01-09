package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[][] firstMatrix = readMatrix(scan);
        int[][] secondMatrix = readMatrix(scan);

        boolean areEqual = compareMatrices(firstMatrix, secondMatrix);

        System.out.println(areEqual ? "equal" : "not equal");
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
