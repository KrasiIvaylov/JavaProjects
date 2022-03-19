package CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String rank = scan.nextLine();
        String suit = scan.nextLine();

        Card card = new Card(CardRank.valueOf(rank), CardSuits.valueOf(suit));
        System.out.println(card);
    }
}
