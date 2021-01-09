package MultidimensionalArraysExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] dimensions = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        int count = 1;

        for (int row = 0; row < rows; row++) {
            ArrayList<Integer> numbers = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                numbers.add(count++);
            }
            matrix.add(numbers);
        }
        String input = scan.nextLine();
        while (!input.equals("Nuke it from orbit")){
            int[] tokens = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            int row = tokens[0];
            int col = tokens[1];
            int radius = tokens[2];

            for (int i = col - radius; i <= col + radius ; i++) {
                if (row >= 0 && row < matrix.size() && i >= 0 && i < matrix.get(row).size()){
                    matrix.get(row).set(i, -1);
                }
            }
            for (int i = row - radius; i <= row + radius ; i++) {
                if (i >= 0 && i < matrix.size() && col >= 0 && col < matrix.get(i).size()){
                    matrix.get(i).set(col, -1);
                }
            }
            for (ArrayList<Integer> integers : matrix){
                removeNum(integers);
            }
            matrix.removeIf(ArrayList::isEmpty);
            input = scan.nextLine();
        }
        printMatrix(matrix);
    }

    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (ArrayList<Integer> integers : matrix) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    private static void removeNum(ArrayList<Integer> integers) {
        while (integers.contains(-1)){
            integers.remove(integers.indexOf(-1));
        }
    }
}
