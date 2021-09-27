package CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Card Ranks:");
        for (CardRank ranks : CardRank.values()){
            System.out.printf("Ordinal value: %d; Name value: %s%n", ranks.ordinal(),ranks);
        }
    }
}
