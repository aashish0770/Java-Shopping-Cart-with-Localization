import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Item> items = new ArrayList<>();

    public void addItems(Item item) {
        items.add(item);
    }

    public double calculateTotal() {
        return items.stream()
                .mapToDouble(Item::getTotal)
                .sum();
    }
}
