package bakery.entities.drinks;

public class Tea extends BaseDrink{
    private static final double DRINK_PRICE = 2.50;

    public Tea(String name, int portion, String brand) {
        super(name, portion, DRINK_PRICE, brand);
    }
}
