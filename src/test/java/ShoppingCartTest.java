import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    @Test
    void testSingleItemTotal() {
        Item item = new Item(10.0, 2);
        double result = item.getTotal();

        assertEquals(20.0, result);
    }

    @Test
    void testMultipleItemsTotal() {
        ShoppingCart cart = new ShoppingCart();

        cart.addItems(new Item(10.0, 2)); // 20
        cart.addItems(new Item(5.0, 3));  // 15

        double result = cart.calculateTotal();

        assertEquals(35.0, result);
    }

    @Test
    void testEmptyCartTotal() {
        ShoppingCart cart = new ShoppingCart();

        double result = cart.calculateTotal();

        assertEquals(0.0, result);
    }

    @Test
    void testDecimalValues() {
        ShoppingCart cart = new ShoppingCart();

        cart.addItems(new Item(2.5, 2)); // 5.0
        cart.addItems(new Item(1.5, 2)); // 3.0

        double result = cart.calculateTotal();

        assertEquals(8.0, result);
    }
}