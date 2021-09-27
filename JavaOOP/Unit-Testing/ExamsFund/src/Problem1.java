import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String word = scan.nextLine();
        String input = scan.nextLine();

        while (!input.equals("For Azeroth")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "GladiatorStance":
                    word = word.toUpperCase();
                    System.out.println(word);
                    break;
                case "DefensiveStance":
                    word = word.toLowerCase();
                    System.out.println(word);
                    break;
                case "Dispel":
                    StringBuilder sb = new StringBuilder(word);
                    int index = Integer.parseInt(tokens[1]);
                    String letter = tokens[2];
                    if (index < 0 || index >= word.length()) {
                        System.out.println("Dispel too weak.");
                    } else {
                        System.out.println("Success!");
                       sb.setCharAt(index, letter.charAt(0));
                       word = sb.toString();
                    }
                    break;
                case "Target":
                    //StringBuilder output = new StringBuilder(word);
                    if (tokens[1].equals("Change")){
                        String first = tokens[2];
                        String second = tokens[3];
                        word =  word.replaceAll(first, second  );
                        System.out.println(word);
                    }else if (tokens[1].equals("Remove")){
                        word = word.replaceAll(tokens[2], "");
                        System.out.println(word);
                    }else{
                        System.out.println("Command doesn't exist!");
                    }
                    break;
                default:
                    System.out.println("Command doesn't exist!");

            }
            input = scan.nextLine();
        }
      //  System.out.println(word);
    }
}
