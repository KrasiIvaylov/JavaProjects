package WildFarm.animals;

import WildFarm.foods.Food;

public class Cat extends Felime{
    private String breed;
    public Cat(String animalName, String animalType, double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void eat(Food food) {
        super.eat(food);
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        StringBuilder baseString = new StringBuilder( super.toString());
        baseString.insert(baseString.indexOf(",") + 1," " +  this.breed + ",");
        return baseString.toString();
    }
}
