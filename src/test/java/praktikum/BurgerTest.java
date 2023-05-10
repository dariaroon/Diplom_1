package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Ingredient ingredient;
    @Mock
    private Bun bun;

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertEquals("Булочка не установлена", bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient);
        assertEquals("Ингридиент не добавлен", 1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue("Ингридиент не удалился", burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "tomato", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "cheese", 100));
        burger.moveIngredient(0, 1);
        String expectedNameIngredient = "cheese";
        String actualNameIngredient = burger.ingredients.get(0).name;
        assertEquals("Неверное имя ингредиента", expectedNameIngredient, actualNameIngredient);
    }

    @Test
    public void testGetPrice() {
        Mockito.when(ingredient.getPrice()).thenReturn(100.0F);
        Mockito.when(bun.getPrice()).thenReturn(100.0F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        float actualPrice = burger.getPrice();
        float expectedPrice = 400.00F;
        assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void testGetReceipt() {
        Mockito.when(bun.getName()).thenReturn("bun");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String actualReceipt = burger.getReceipt();
        String expectedReceipt = "(==== bun ====)" +
            System.lineSeparator() +
            "= filling cutlet =" +
            System.lineSeparator() +
            "(==== bun ====)" +
            System.lineSeparator() +
            System.lineSeparator() +
            "Price: 300,000000" +
            System.lineSeparator();
        assertEquals(expectedReceipt, actualReceipt);
    }
}