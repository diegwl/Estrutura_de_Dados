import java.util.ArrayList;
import java.util.Scanner;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return name + " - $" + price;
    }
}

public class ShoppingCart {
    private ArrayList<Product> cart;

    public ShoppingCart() {
        cart = new ArrayList<>();
    }

    public void addItem(Product product) {
        cart.add(product);
        System.out.println(product.getName() + " added to cart.");
    }

    public void removeItem(int index) {
        Product product = cart.get(index);
        cart.remove(index);
        System.out.println(product.getName() + " removed from cart.");
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product product : cart) {
            total += product.getPrice();
        }
        return total;
    }

    public void displayCart() {
        if (cart.size() == 0) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Your cart:");
            for (Product product : cart) {
                System.out.println(product.toString());
            }
            System.out.println("Total price: $" + getTotalPrice());
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. Display cart");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Enter item name:");
                String name = scanner.next();
                System.out.println("Enter item price:");
                double price = scanner.nextDouble();
                Product product = new Product(name, price);
                cart.addItem(product);
            } else if (choice == 2) {
                System.out.println("Enter index of item to remove:");
                int index = scanner.nextInt();
                cart.removeItem(index);
            } else if (choice == 3) {
                cart.displayCart();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        System.out.println("Thanks for shopping!");
    }
}
