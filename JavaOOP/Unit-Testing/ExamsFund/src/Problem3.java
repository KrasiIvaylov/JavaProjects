import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> heroAndSpells = new TreeMap<>();

        String command = scan.nextLine();
        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            switch (tokens[0]) {
                case "Enroll":
                    if (heroAndSpells.containsKey(tokens[1])){
                        System.out.println
                                (String.format("%s is already enrolled.",
                                        tokens[1]));
                        break;
                    }
                    heroAndSpells.put(tokens[1], new ArrayList<>());
                    break;
                case "Learn":
                    String spell = tokens[2];
                    if (!heroAndSpells.containsKey(tokens[1])){
                        System.out.println(String.format("%s doesn't exist.",
                                tokens[1]));
                        break;
                    }else if (heroAndSpells.get(tokens[1]).contains(spell)){
                        System.out.println(String.format("%s has already learnt %s.",
                                tokens[1], spell));
                        break;
                    }
                    heroAndSpells.putIfAbsent(tokens[1], new ArrayList<>());
                    heroAndSpells.get(tokens[1]).add(spell);
                    break;
                case "Unlearn":
                    spell = tokens[2];
                    if (!heroAndSpells.containsKey(tokens[1])){
                        System.out.println(String.format("%s doesn't exist.",
                                tokens[1]));
                        break;
                    }else if (!heroAndSpells.get(tokens[1]).contains(spell)){
                        System.out.println(String.format("%s doesn't know %s.",
                                tokens[1], spell));
                        break;
                    }
                    heroAndSpells.get(tokens[1]).remove(spell);
                    break;
            }

            command = scan.nextLine();
        }

        System.out.println("Heroes:");
        heroAndSpells.entrySet().stream()
                .sorted((h1, h2) -> {
                    int result = heroAndSpells.get(h1.getKey()).size() -
                            heroAndSpells.get(h2.getKey()).size();
                    if (result == 0) {
                        result = h1.getKey().compareTo(h2.getKey());
                    }

                    return result;
                })
                .forEach(entry -> {
                    System.out.println(String.format("== %s: %s",
                            entry.getKey(), String.join(", ", entry.getValue())));
                });
    }
}
