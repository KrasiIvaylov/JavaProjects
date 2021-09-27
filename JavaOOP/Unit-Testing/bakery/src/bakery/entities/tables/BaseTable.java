package bakery.entities.tables;

import bakery.common.OutputMessages;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import static bakery.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static bakery.common.ExceptionMessages.INVALID_TABLE_CAPACITY;

public abstract class BaseTable implements Table {
    //   public static Collection<BakedFood> foodOrders;
    //   public static Collection<Drink> drinkOrders;
    private Collection<BakedFood> foodOrders;
    private Collection<Drink> drinkOrders;

    private int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    protected BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.foodOrders = new LinkedList<>();
        this.drinkOrders = new LinkedList<>();

        this.tableNumber = tableNumber;
        this.setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
    }

    @Override
    public int getTableNumber() {
        return this.tableNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    private void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        if (numberOfPeople <= 0 ){
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
        this.price = this.pricePerPerson * this.numberOfPeople;
        this.isReserved = true;
    }

    @Override
    public void orderFood(BakedFood food) {
        this.foodOrders.add(food);
    }

    @Override
    public void orderDrink(Drink drink) {
        this.drinkOrders.add(drink);
    }

    @Override
    public double getBill() {
        double drinkBill =
                this.drinkOrders
                        .stream()
                        .mapToDouble(Drink::getPrice)
                        .sum();
        double foodBill =
                this.foodOrders
                        .stream()
                        .mapToDouble(BakedFood::getPrice)
                        .sum();

        return drinkBill + foodBill + getPrice();
    }



    @Override
    public void clear() {
        this.foodOrders.clear();
        this.drinkOrders.clear();

        this.isReserved = false;
        this.numberOfPeople = 0;
        this.price = 0;
    }


    @Override
    public String getFreeTableInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Table: %d", this.getTableNumber()))
                .append(System.lineSeparator());
        sb.append(String.format("Type: %s", this.getClass().getSimpleName()))
                .append(System.lineSeparator());
        sb.append(String.format("Capacity: %d", this.getCapacity()))
                .append(System.lineSeparator());
        sb.append(String.format("Price per Person: %.2f", this.getPricePerPerson()));

        return sb.toString().trim();
    }


}
