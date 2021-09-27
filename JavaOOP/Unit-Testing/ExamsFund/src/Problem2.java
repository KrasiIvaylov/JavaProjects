import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            String regex = "(\\|)(?<bossName>[A-Z]{4,})\\1:(#)(?<titleName>[A-Za-z]+ [A-Za-z]+)\\3";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            boolean isFind = false;
            while (matcher.find()) {
                isFind = true;
                String bossName = matcher.group("bossName");
                String titleName = matcher.group("titleName");

                System.out.println(String.format("%s, The %s",
                        bossName, titleName));
                System.out.println(String.format(">> Strength: %d",
                        bossName.length()));
                System.out.println(String.format(">> Armour: %d",
                        titleName.length()));
            }

            if (!isFind) {
                System.out.println("Access denied!");
            }
        }
    }
}
