package TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] startLights = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(scan.nextLine());

        List<TrafficLights> trafficLights = new ArrayList<TrafficLights>();

        for (String light : startLights){
            TrafficLights trafficLight = new TrafficLights(Lights.valueOf(light));
            trafficLights.add(trafficLight);
        }
        for (int i = 0; i < n; i++) {
            for (TrafficLights lights : trafficLights){
                lights.update();
                System.out.print(lights.getLights() + " ");
            }
            System.out.println();
        }
    }
}
