package rpg_lab;

import org.junit.Test;

import static org.junit.Assert.*;

public class AxeTest {

    @Test
    public void testAxeLoosesDurabilityAfterAttack(){
        Axe axe = new Axe(10, 10);
        Dummy dummy = new Dummy(10, 10);

        axe.attack(dummy);
        assertEquals(9, axe.getDurabilityPoints());
    }

    @Test
    public void testAxeCanLooseAllDurabilityAfterAttack(){
        Axe axe = new Axe(10, 10);
        Dummy dummy = new Dummy(1000, 10);

        for (int i = 0; i < 10; i++) {
            axe.attack(dummy);
        }
        assertEquals(0, axe.getDurabilityPoints());
    }

    @Test
    public void testAttackWithBrokenAxe(){
        Axe axe = new Axe(10, 0);
        Dummy dummy = new Dummy(1000, 10);

        axe.attack(dummy);
    }

}