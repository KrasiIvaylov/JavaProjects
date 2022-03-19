package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        for (int index = 0; index < size; index++) {
            System.out.print(matrix[index][index] + " ");
        }
        System.out.println();
        for (int index = 0; index < size; index++) {
            System.out.print(matrix[(size -1) - index][index] + " ");
        }
    }
}
