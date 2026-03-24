import java.util.Locale;
import java.util.Scanner;
import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Language selection
        System.out.println("Select the language");
        System.out.println(" 1. English");
        System.out.println(" 2. Finnish");
        System.out.println(" 3. Swedish");
        System.out.println(" 4. Japanese");

        int choice = sc.nextInt();

        Locale locale;
        switch (choice) {
            case 1:
                locale = new Locale("en", "US");
                break;
            case 2:
                locale = new Locale("fi", "FI");
                break;
            case 3:
                locale = new Locale("sv", "SE");
                break;
            case 4:
                locale = new Locale("ja", "JP");
                break;
            default:
                locale = new Locale("en", "US");
        }

        ResourceBundle rb = ResourceBundle.getBundle("Messages", locale);

        //Ask number of items
        System.out.println(rb.getString("enter.items"));
        int numberOfItems = sc.nextInt();
        ShoppingCart cart = new ShoppingCart();

        // loop items
        for (int i = 0; i < numberOfItems; i++) {

            System.out.println(rb.getString("enter.price"));
            double price = sc.nextDouble();

            System.out.println(rb.getString("enter.quantity"));
            int quantity = sc.nextInt();

            cart.addItems(new Item(price, quantity));
        }

        double total = cart.calculateTotal();
        System.out.println(rb.getString("total.cost") + " " + total);
    }
}
