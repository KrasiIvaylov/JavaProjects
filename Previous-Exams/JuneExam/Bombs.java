package JuneExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Bombs {
    static BufferedReader console =
            new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter printWriter =
            new PrintWriter(System.out);
    /*
    •	 Datura Bombs: 40
    •	Cherry Bombs 60
    •	Smoke Decoy Bombs: 120
    5, 25, 50, 115
    5, 15, 25, 35
     */

    public static void main(String[] args) throws IOException {
        ArrayDeque<Integer> bombEffects = readBombs(console);
        ArrayDeque<Integer> bombCasings = readBombs(console);

        int detura = 0;
        int cherry = 0;
        int smoke = 0;
        while(!bombEffects.isEmpty() && !bombCasings.isEmpty()) {
            if (detura >= 3 && cherry >= 3 && smoke >= 3){
                break;
            }
            int effect = bombEffects.pop();
            int casing = bombCasings.pollLast();
            int sum = effect + casing;
            if(sum == 40) {
                detura++;
            } else if(sum == 60) {
                cherry++;
            } else if(sum == 120) {
                smoke++;
            } else {
                while(sum != 40 || sum != 60 || sum != 120){
                    if (casing == 0){
                        continue;
                    }
                    casing -= 5;
                    sum -= 5;
                    if (sum == 40){
                        detura++;
                        break;
                    }else if (sum == 60){
                        cherry++;
                        break;
                    }else if (sum == 120){
                        smoke++;
                        break;
                    }
                }
            }


        }
        if (detura >= 3 && cherry >= 3 && smoke >= 3) {
            printWriter.println(String.format("Bene! You have successfully filled the bomb pouch!"));
        }else{
            printWriter.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (bombEffects.isEmpty()){
            printWriter.println("Bomb Effects: empty");
        }else{
            printWriter.print("Bomb Effects: ");
            String output = bombEffects.stream().map(String::valueOf).collect(Collectors.joining(", "));
           printWriter.print(output);
            printWriter.println();
        }
        if (bombCasings.isEmpty()){
            printWriter.println("Bomb Casings: empty");
        }else{
            printWriter.print("Bomb Casings: ");
            String output = bombCasings.stream().map(String::valueOf).collect(Collectors.joining(", "));
         printWriter.print(output);
            printWriter.println();
        }
        printWriter.print(String.format("Cherry Bombs: %d%n" +
                "Datura Bombs: %d%n" +
                "Smoke Decoy Bombs: %d", cherry, detura, smoke));



        printWriter.close(); console.close();
    }

    private static ArrayDeque<Integer> readBombs(BufferedReader console) throws IOException {
        return Arrays.
                stream(console.readLine().split(", *"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
    }

}
