package MultidimensionalArraysExercise;

import java.util.ArrayList;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String rotation = scan.nextLine();
        int angleRotation = Integer.parseInt(rotation.split("[()]+")[1]) % 360;

        ArrayList<String> linesForMatrix = new ArrayList<>();
        int maxLength = 0;

        while (true){
            String line = scan.nextLine();
            if (line.equals("END")){
                break;
            }
            linesForMatrix.add(line);
            if (line.length() > maxLength){
                maxLength = line.length();
            }
        }
        int rows = linesForMatrix.size();
        int cols = maxLength;
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col < linesForMatrix.get(row).length()){
                    matrix[row][col] = linesForMatrix.get(row).charAt(col);
                }else{
                    matrix[row][col] = ' ';
                }
            }
        }
        if (angleRotation == 90){
            for (int col = 0; col < cols; col++) {
                for (int row = rows - 1; row >= 0; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }else if (angleRotation == 180){
            for (int row = rows -1; row >= 0 ; row--) {
                for (int col = cols -1; col >= 0 ; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }else if (angleRotation == 270){
            for (int col = cols - 1; col >= 0 ; col--) {
                for (int row = 0; row < rows; row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }else{
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }

    }
    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
