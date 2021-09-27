package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {
    Spaceship spaceship = new Spaceship("Krasi", 20);

    @Before
    public void prep(){
        this.spaceship = new Spaceship("Krasi", 20);
    }

    @Test
    public void test1(){
        Assert.assertEquals(20, spaceship.getCapacity());
    }

    @Test
    public void test3(){
        Spaceship spaceship = new Spaceship("SpaceX", 20);
        Astronaut astronaut = new Astronaut("Krasi", 100.00);
        spaceship.add(astronaut);
        Assert.assertEquals(1, spaceship.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test4(){
        Astronaut astronaut = new Astronaut("Krasi", 100.00);
        spaceship.add(astronaut);
        spaceship.add(astronaut);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test5(){
        Spaceship spaceship = new Spaceship("SpaceX", 1);
        Astronaut astronaut = new Astronaut("Krasi", 100.00);
        spaceship.add(astronaut);
        Astronaut astronaut2 = new Astronaut("New", 100.00);
        spaceship.add(astronaut2);
    }

    @Test
    public void test6   (){
        Spaceship spaceship = new Spaceship("SpaceX", 1);
        Astronaut astronaut = new Astronaut("Krasi", 100.00);
       spaceship.add(astronaut);
        Assert.assertEquals(true, spaceship.remove("Krasi"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test7   (){
        Spaceship spaceship = new Spaceship("SpaceX", -1);
        Astronaut astronaut = new Astronaut("Krasi", 100.00);
    }
    @Test
    public void test8   (){
        Spaceship spaceship = new Spaceship("SpaceX", 10);
        Astronaut astronaut = new Astronaut("Krasi", 100.00);
        Assert.assertEquals(10, spaceship.getCapacity());
    }

    @Test(expected = NullPointerException.class)
    public void test9   (){
        Spaceship spaceship = new Spaceship(null, -1);
        Astronaut astronaut = new Astronaut("Krasi", 100.00);

    }


    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Spaceship
}
