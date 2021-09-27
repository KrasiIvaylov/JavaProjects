package JuneExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Snake {
    static BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter writer = new PrintWriter(System.out);


    public static void main(String[] args) throws IOException {
        int rowsAndCols = Integer.parseInt(reader.readLine());
        char[][] territory = readCharArr(rowsAndCols, reader);

        int[] pos = findInitialPosition(territory);   //[0] stands for row;  [1] stand for col

        int foodQuantity = 0;
        String input = reader.readLine();
        boolean isOutOfBounds = false;
        while (true) {
            switch (input) {
                case "up":
                    if (isInBounds(pos[0] - 1, pos[1], territory)) {
                        char symbol = territory[pos[0] - 1][pos[1]];
                        switch (symbol) {
                            case '*':
                                foodQuantity++;
                                territory[pos[0]][pos[1]] = '.';
                                territory[pos[0] - 1][pos[1]] = 'S';

                                pos[0] = pos[0] - 1;
                                break;

                            case '-':
                                territory[pos[0]][pos[1]] = '.';
                                territory[pos[0] - 1][pos[1]] = 'S';

                                pos[0] = pos[0] - 1;
                                break;

                            case 'B':
                                caseB(pos, territory);
                                break;
                        }

                    } else {
                        territory[pos[0]][pos[1]] = '.';
                        isOutOfBounds = true;
                        break;
                    }
                    break;

                case "down":
                    if (isInBounds(pos[0] + 1, pos[1], territory)) {
                        char symbol = territory[pos[0] + 1][pos[1]];
                        switch (symbol) {
                            case '*':
                                foodQuantity++;
                                territory[pos[0]][pos[1]] = '.';
                                territory[pos[0] + 1][pos[1]] = 'S';

                                pos[0] = pos[0] + 1;
                                break;

                            case '-':
                                territory[pos[0]][pos[1]] = '.';
                                territory[pos[0] + 1][pos[1]] = 'S';

                                pos[0] = pos[0] + 1;
                                break;

                            case 'B':
                                caseB(pos, territory);
                                break;
                        }

                    }
                    else {
                        territory[pos[0]][pos[1]] = '.';
                        isOutOfBounds = true;
                        break;
                    }
                    break;


                case "left":
                    if (isInBounds(pos[0], pos[1] - 1, territory)) {
                        char symbol = territory[pos[0]][pos[1] - 1];
                        switch (symbol) {
                            case '*':
                                foodQuantity++;
                                territory[pos[0]][pos[1]] = '.';
                                territory[pos[0]][pos[1] - 1] = 'S';

                                pos[1] = pos[1] - 1;
                                break;

                            case '-':
                                territory[pos[0]][pos[1]] = '.';
                                territory[pos[0]][pos[1] - 1] = 'S';

                                pos[1] = pos[1] - 1;
                                break;

                            case 'B':
                                caseB(pos, territory);
                                break;
                        }

                    }
                    else {
                        territory[pos[0]][pos[1]] = '.';
                        isOutOfBounds = true;
                        break;
                    }
                    break;

                case "right":
                    if (isInBounds(pos[0], pos[1] + 1, territory)) {
                        char symbol = territory[pos[0]][pos[1] + 1];
                        switch (symbol) {
                            case '*':
                                foodQuantity++;
                                territory[pos[0]][pos[1]] = '.';
                                territory[pos[0]][pos[1] + 1] = 'S';

                                pos[1] = pos[1] + 1;
                                break;

                            case '-':
                                territory[pos[0]][pos[1]] = '.';
                                territory[pos[0]][pos[1] + 1] = 'S';

                                pos[1] = pos[1] + 1;
                                break;

                            case 'B':
                                caseB(pos, territory);
                                break;
                        }

                    } else {
                        territory[pos[0]][pos[1]] = '.';
                        isOutOfBounds = true;
                        break;
                    }
                    break;
            }
            if(isOutOfBounds || foodQuantity >= 10) {
                break;
            }

            writer.flush();

            input = reader.readLine();
        }

        if(isOutOfBounds) {
            writer.println("Game over!");
        } else {
            writer.println("You won! You fed the snake.");
        }
        writer.println("Food eaten: " + foodQuantity);
        for (int row = 0; row < territory.length; row++) {
            for (int col = 0; col < territory[row].length; col++) {
                writer.print(territory[row][col]);
            }
            writer.println();
        }

        reader.close(); writer.close();
    }

    private static void caseB(int[] pos, char[][] territory) {
        territory[pos[0]][pos[1]] = '.';

        boolean isSFound = false;
        for (int row = 0; row < territory.length; row++) {
            for (int col = 0; col < territory[row].length; col++) {
                if(territory[row][col] == 'B') {
                    if(!isSFound) {
                        isSFound = true;
                        territory[row][col] = '.';
                    }
                    else {
                        territory[row][col] = 'S';
                    }

                    pos[0] = row;
                    pos[1] = col;
                }
            }
        }
    }

    private static int[] findInitialPosition(char[][] territory) {
        int[] pos = new int[2];
        boolean isFind = false;
        for (int row = 0; row < territory.length; row++) {
            for (int col = 0; col < territory[row].length; col++) {
                if (territory[row][col] == 'S') {
                    isFind = true;
                    pos[0] = row;
                    pos[1] = col;
                    break;
                }
            }
            if (isFind) {
                break;
            }
        }
        return pos;
    }

    private static char[][] readCharArr(int rowsAndCols, BufferedReader reader) {
        return reader
                .lines()
                .limit(rowsAndCols)
                .map(line -> line.toCharArray())
                .toArray(char[][]::new);
    }

    private static boolean isInBounds(int row, int col, char[][] territory) {
        return row >= 0 && row < territory.length &&
                col >= 0 && col < territory[row].length;
    }
}
