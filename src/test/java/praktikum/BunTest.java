package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void testGetName() {
        Bun bun = new Bun("Булочка с кунжутом", 1.0F);
        assertEquals("Булочка с кунжутом", bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("Булочка с кунжутом", 10.0F);
        assertEquals(10.0F, bun.getPrice(), 0);
    }
}