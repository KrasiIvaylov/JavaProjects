package bakery.entities.tables;

public class OutsideTable extends BaseTable{
    private static final double CONSTANT_VALUE = 3.50;

    public OutsideTable(int tableNumber, int capacity) {
        super(tableNumber, capacity, CONSTANT_VALUE);
    }
}
