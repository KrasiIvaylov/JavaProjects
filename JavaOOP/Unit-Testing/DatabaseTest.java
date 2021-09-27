package p01_Database;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    @Test
    public void testConstructorThatHasToCreateValidObject()
            throws OperationNotSupportedException {

        Integer[] numbers = {5, 9, 29, 45};
        Database database = new Database(numbers);
        Integer[] databaseNumbers = database.getElements();
        Assert.assertEquals(
                "Count of elements is incorrect", numbers.length, databaseNumbers.length);

        for (int i = 0; i < databaseNumbers.length; i++) {
            Assert.assertEquals(numbers[i], databaseNumbers[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenUseMoreThanSixteenElements()
            throws OperationNotSupportedException {

        Integer[] numbers = new Integer[17];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenUseLessThanOneElemens()
            throws OperationNotSupportedException {

        Integer[] numbers = new Integer[0];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExWhenParamNull()
            throws OperationNotSupportedException {

        Integer[] numbers = {5, 9, 29, 45};
        Database database = new Database(numbers);
        database.add(null);
    }

    @Test
    public void testAddShouldAddElement()
            throws OperationNotSupportedException {

        Integer[] numbers = {5, 9, 29, 45};
        Database database = new Database(numbers);
        database.add(17);
        Assert.assertEquals(5, database.getElements().length);
        Assert.assertEquals(Integer.valueOf(17), database.getElements()[4]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowExWithEmptyData()
            throws OperationNotSupportedException {

        Integer[] numbers = {5, 9, 29, 45};
        Database database = new Database(numbers);

        for (int i = 0; i < numbers.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void removeLastElement()
            throws OperationNotSupportedException {

        Integer[] numbers = {5, 9, 29, 45};
        Database database = new Database(numbers);

        database.remove();
        Assert.assertEquals(3, database.getElements().length);
    }


}