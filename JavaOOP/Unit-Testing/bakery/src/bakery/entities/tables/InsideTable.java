package bakery.entities.tables;

public class InsideTable extends BaseTable{
    private static final double CONSTANT_VALUE = 2.50;

    public InsideTable(int tableNumber, int capacity) {
        super(tableNumber, capacity, CONSTANT_VALUE);
    }


}
