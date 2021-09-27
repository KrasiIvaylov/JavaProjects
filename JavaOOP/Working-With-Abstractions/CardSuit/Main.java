package CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Card Suits:");
        for (CardSuits suits : CardSuits.values()){
            System.out.printf("Ordinal value: %d; Name value: %s%n",suits.ordinal(), suits);
        }
    }
}
