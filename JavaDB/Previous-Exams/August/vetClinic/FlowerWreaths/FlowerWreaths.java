package August.vetClinic.FlowerWreaths;

import java.util.*;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        ArrayDeque<Integer> roses = new ArrayDeque<>();
        int wreaths = 0;
        int rest = 0;
        int toCreate = 0;
        int sum = 0;

        Arrays.stream(scan.nextLine().split(", ")).forEach(e -> lilies.push(Integer.parseInt(e)));
        Arrays.stream(scan.nextLine().split(", ")).forEach(e -> roses.offer(Integer.parseInt(e)));
        while (!roses.isEmpty()){
            int lilie = lilies.peek();
            int rose = roses.peek();
            sum = lilies.pop() + roses.poll();
            if (sum == 15){
                wreaths++;
            }else if (sum > 15){
                lilie -= 2;
                sum = rose + lilie;
                if (sum == 15){
                    wreaths++;
                    sum = 0;
                }
            }else{
                toCreate += sum;
                sum = 0;
            }
        }
        if (wreaths == 5){
            System.out.println(String.format("You made it, you are going to the competition with %d wreaths!", wreaths));
        }else{
            System.out.println(String.format("You didn't make it, you need %d wreaths more!", wreaths));
        }
    }
}
