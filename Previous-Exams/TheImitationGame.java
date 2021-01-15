import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String message = scan.nextLine();
        String input = scan.nextLine();
        while (!input.equals("Decode")) {
            String[] tokens = input.split("\\|");
            String command = tokens[0];
            switch (command) {
                case "Move":
                    StringBuilder sb = new StringBuilder(message);
                    int toMove = Integer.parseInt(tokens[1]);
                    String moved = message.substring(0,toMove);
                    if (toMove <= message.length()) {
                        message = sb.append(moved).toString();
                        message = message.replaceFirst(moved, "");
                    }
                    break;
                case "Insert":
                    StringBuilder db = new StringBuilder(message);
                    int index = Integer.parseInt(tokens[1]);
                    String value = tokens[2];
                    if (index >=0 && index <= message.length()) {
                        message = db.insert(index, value).toString();
                    }
                    break;
                case "ChangeAll":
                    StringBuilder fb = new StringBuilder(message);
                    String occurance = tokens[1];
                    String replacement = tokens[2];
                    if (message.contains(occurance)){
                        int indexToReplace = message.indexOf(occurance);
                        while (indexToReplace >= 0){
                            message = message.replace(occurance, replacement);
                            indexToReplace = message.indexOf(occurance.charAt(0));
                        }
                    }

                    break;
            }
            input = scan.nextLine();
        }
        System.out.println(String.format("The decrypted message is: %s", message));
    }
}
