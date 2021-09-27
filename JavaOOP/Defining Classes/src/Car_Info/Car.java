package Car_Info;

import java.util.Objects;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    private int verifyHorsepowerNotLessThenOne(int horsePower){
        return Math.max(horsePower, 0);
    }
    public void setHorsePower(int horsePower) {
        this.horsePower = verifyHorsepowerNotLessThenOne(horsePower);
    }
    public void increaseHP(int value){
        horsePower += verifyHorsepowerNotLessThenOne(horsePower);
    }
    public String carInfo(){
        return this.toString();
    }

    @Override
    public String toString(){
        return String.format("The car is: %s %s - %d HP.",
                this.getBrand(), this.getModel(), this.getHorsePower());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return horsePower == car.horsePower &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, horsePower);
    }
}
