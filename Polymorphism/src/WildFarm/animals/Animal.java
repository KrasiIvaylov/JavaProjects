package WildFarm.animals;

import WildFarm.foods.Food;

import java.text.DecimalFormat;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private double animalWeight;
    private int foodEaten;
    private String livingRegion;

    protected Animal(String animalName, String animalType, double animalWeight, String livingRegion) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.livingRegion = livingRegion;
    }

    protected String getAnimalType() {
        return this.animalType;
    }

    public abstract void makeSound();

    public void eat(Food food) {
        this.foodEaten += food.getQuantity();
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %d]"
        ,this.animalType, this.animalName, formatter.format(this.animalWeight),
                this.livingRegion, this.foodEaten
                );
    }
}
