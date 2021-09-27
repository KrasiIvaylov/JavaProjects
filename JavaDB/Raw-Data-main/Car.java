package RawData;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private int speed;
    private int power;
    private int weight;
    private String type;
    private List<Tires> tires;

    public Car(String model, int speed, int power, int weight, String type) {
        this.model = model;
        this.speed = speed;
        this.power = power;
        this.weight = weight;
        this.type = type;
        this.tires = new ArrayList<>();
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public String getType() {
        return type;
    }

    public List<Tires> getTires() {
        return tires;
    }

    public boolean isPressureLess() {
        for (Tires e : this.tires){
            if (e.getPressure()){
                return true;
            }
        }
        return false;
    }
}
