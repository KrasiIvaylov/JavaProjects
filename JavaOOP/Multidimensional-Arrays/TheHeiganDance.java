package MultidimensionalArraysExercise;

import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int playerRow = 7;
        int playerCol = 7;
        int hp = 18500;
        double bossHP = 3000000;
        double dmg = Double.parseDouble(scan.nextLine());
        String lastSpell = "";
        while (true) {
            if (hp >= 0) {
                bossHP -= dmg;
            }
            if (lastSpell.equals("Cloud")) {
                hp -= 3500;
            }
            if (bossHP <= 0 || hp <= 0) {
                break;
            }
            String[] input = scan.nextLine().split("\\s+");
            String curSpell = input[0];
            int targetRow = Integer.parseInt(input[1]);
            int targetCol = Integer.parseInt(input[2]);
            if (isInArea(targetRow, targetCol, playerRow, playerCol)) {
                if (!isInArea(targetRow, targetCol, playerRow - 1, playerCol) && !isWall(playerRow - 1)) {
                    playerRow--;
                    lastSpell = "";
                }else if (!isInArea(targetRow, targetCol, playerRow, playerCol + 1) && !isWall(playerCol + 1)){
                    playerCol++;
                    lastSpell = "";
                }else if (!isInArea(targetRow, targetCol, playerRow + 1, playerCol) && !isWall(playerRow + 1)) {
                    playerRow++;
                    lastSpell = "";
                } else if (!isInArea(targetRow, targetCol, playerRow, playerCol - 1) && !isWall(playerCol - 1)) {
                    playerCol--;
                    lastSpell = "";
                }else{
                    if (curSpell.equals("Cloud")){
                        hp -= 3500;
                        lastSpell = "Cloud";
                    }else if (curSpell.equals("Eruption")){
                        hp -= 6000;
                        lastSpell = "Eruption";
                    }
                }
            }
        }
        lastSpell = lastSpell.equals("Cloud") ? "Plague Cloud" : "Eruption";
        String heiganState = bossHP <= 0 ? "Heigan: Defeated!" : String.format("Heigan: %.2f", bossHP);
        String playerState = hp <= 0 ? String.format("Player: Killed by %s", lastSpell) :
                String.format("Player: %d", hp);
        String playerEndCoordinates = String.format("Final position: %d, %d", playerRow, playerCol);

        System.out.println(heiganState);
        System.out.println(playerState);
        System.out.println(playerEndCoordinates);
    }
        private static boolean isWall(int moveCell) {
            return moveCell < 0 || moveCell >= 15;
        }
    private static boolean isInArea(int targetRow, int targetCol, int moveRow, int moveCol) {
        return ((targetRow - 1 <= moveRow && moveRow <= targetRow + 1)
                && (targetCol - 1 <= moveCol && moveCol <= targetCol + 1));
    }
}
