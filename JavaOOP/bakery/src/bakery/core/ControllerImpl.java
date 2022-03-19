package bakery.core;

import bakery.common.ExceptionMessages;
import bakery.common.OutputMessages;
import bakery.core.interfaces.Controller;
import bakery.entities.bakedFoods.BaseFood;
import bakery.entities.bakedFoods.Bread;
import bakery.entities.bakedFoods.Cake;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.Tea;
import bakery.entities.drinks.Water;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.BaseTable;
import bakery.entities.tables.InsideTable;
import bakery.entities.tables.OutsideTable;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.DrinkRepository;
import bakery.repositories.interfaces.FoodRepository;
import bakery.repositories.interfaces.TableRepository;

import static bakery.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private FoodRepository<BakedFood> foodRepository;
    private DrinkRepository<Drink> drinkRepository;
    private TableRepository<Table> tableRepository;
    private double totalIncome;

    public ControllerImpl(FoodRepository<BakedFood> foodRepository,
                          DrinkRepository<Drink> drinkRepository, TableRepository<Table> tableRepository) {
        this.foodRepository = foodRepository;
        this.drinkRepository = drinkRepository;
        this.tableRepository = tableRepository;
        this.totalIncome = 0.0;
    }


    @Override
    public String addFood(String type, String name, double price) {
        BaseFood food = null;
        if (this.foodRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
        }
        if (type.equals("Bread")) {
            food = new Bread(name, price);
        } else if (type.equals("Cake")) {
            food = new Cake(name, price);
        }else{
            throw new IllegalArgumentException(String.format("Invalid food type"));

        }
        this.foodRepository.add(food);
        return String.format(OutputMessages.FOOD_ADDED, name, type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        Drink drink = null;
        if (this.drinkRepository.getByNameAndBrand(name, brand) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
        }
        switch (type) {
            case "Tea":
                drink = new Tea(name, portion, brand);
                break;
            case "Water":
                drink = new Water(name, portion, brand);
                break;
        }
        drinkRepository.add(drink);
        return String.format(OutputMessages.DRINK_ADDED, name, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = null;
        if (tableRepository.getByNumber(tableNumber) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.TABLE_EXIST, tableNumber));
        }
        switch (type) {
            case "OutsideTable":
                table = new OutsideTable(tableNumber, capacity);
                break;
            case "InsideTable":
                table  = new InsideTable(tableNumber, capacity);
                break;
        }
        tableRepository.add(table);
        return String.format(OutputMessages.TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {
        boolean reserved = false;
        int tableNumber = 0;
        for (Table table : this.tableRepository.getAll() ) {
            if (!table.isReserved() && table.getCapacity() >= numberOfPeople){
                table.reserve(numberOfPeople);
                reserved = true;
                tableNumber = table.getTableNumber();
                break;
            }
        }
        if (reserved){
            return String.format(TABLE_RESERVED, tableNumber, numberOfPeople    );
        }else{
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        Table table = this.tableRepository.getByNumber(tableNumber);

        if (table == null || !table.isReserved()){
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }else if (this.foodRepository.getByName(foodName) == null){
            return String.format(NONE_EXISTENT_FOOD, foodName);
        }
        BakedFood food = this.foodRepository.getByName(foodName);
        this.tableRepository.getByNumber(tableNumber).orderFood(food);
        return String.format(FOOD_ORDER_SUCCESSFUL, tableNumber, foodName);
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
      Table table = this.tableRepository.getByNumber(tableNumber);
        if (table == null || !table.isReserved()){
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }else if (this.drinkRepository.getByNameAndBrand(drinkName, drinkBrand) == null){
            return String.format(NON_EXISTENT_DRINK, drinkName, drinkBrand);
        }
        Drink drink = this.drinkRepository.getByNameAndBrand(drinkName, drinkBrand);
        this.tableRepository.getByNumber(tableNumber).orderDrink(drink);
        return String.format(DRINK_ORDER_SUCCESSFUL, tableNumber, drinkName, drinkBrand);


    }

    @Override
    public String leaveTable(int tableNumber) {
        Table table = this.tableRepository.getByNumber(tableNumber);
        if (table == null){
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        double bill = table.getBill();
        this.totalIncome += bill;
        table.clear();
        return String.format(BILL, tableNumber, bill);
    }

    @Override
    public String getFreeTablesInfo() {
        StringBuilder output = new StringBuilder();
        for (Table table : this.tableRepository.getAll()) {
            if (!table.isReserved()){
                output.append(table.getFreeTableInfo())
                        .append(System.lineSeparator());
            }
        }
        return output.toString().trim();
    }

    @Override
    public String getTotalIncome() {
        return String.format(TOTAL_INCOME, this.totalIncome);
    }
}
