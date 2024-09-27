package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {

    Ingredient ingredient;
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] ingredientData() {
        return new Object[][]{
            {SAUCE, "hot sauce", 100},
            {SAUCE, "chili sauce", 300},
            {FILLING, "dinosaur", 200},
            {FILLING, "sausage", 300}
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void testGetPrice() {
        assertEquals("Неверная цена", price, ingredient.getPrice(), 0);
    }

    @Test
    public void testGetName() {
        assertEquals("Неверное название", name, ingredient.getName());

    }

    @Test
    public void testGetType() {
        assertEquals("Неверный тип ингридиента", type, ingredient.getType());

    }
}