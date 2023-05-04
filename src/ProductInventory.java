import java.util.*;

public class ProductInventory {
    // Create a Map to store product information
    private final Map<String, Product> inventory;

    // Constructor to initialize the inventory
    public ProductInventory() {
        inventory = new HashMap<>();
    }

    // Method to add a new product to the inventory
    public void addProduct(String name, double price, int quantity) {
        inventory.put(name, new Product(price, quantity));
    }

    // Method to update the price of a product in the inventory
    public void updatePrice(String name, double price) {
        Product product = inventory.get(name);
        if (product != null) {
            product.setPrice(price);
        }
    }

    // Method to update the quantity of a product in the inventory
    public void updateQuantity(String name, int quantity) {
        Product product = inventory.get(name);
        if (product != null) {
            product.setQuantity(quantity);
        }
    }

    // Method to search for a product in the inventory
    public Product searchProduct(String name) {
        return inventory.get(name);
    }

    // Method to display the inventory
    public void displayInventory() {
        for (String name : inventory.keySet()) {
            Product product = inventory.get(name);
            System.out.println("Product Name: " + name);
            System.out.println("Price: " + product.getPrice());
            System.out.println("Quantity: " + product.getQuantity());
            System.out.println("-------------------------");
        }
    }

    // Inner class to represent a product
    private static class Product {
        private double price;
        private int quantity;

        public Product(double price, int quantity) {
            this.price = price;
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

    public static void main(String[] args) {
        ProductInventory inventory = new ProductInventory();
        Scanner scanner = new Scanner(System.in);
        int choice;
        String name;
        double price;
        int quantity;
        boolean exit = false;

        while (!exit) {
            System.out.println("Please select an option:");
            System.out.println("1. Add a product");
            System.out.println("2. Update the price of a product");
            System.out.println("3. Update the quantity of a product");
            System.out.println("4. Search for a product");
            System.out.println("5. Display the inventory");
            System.out.println("6. Exit");
            System.out.println("-------------------------");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter the product name:");
                    name = scanner.next();
                    System.out.println("Enter the product price:");
                    price = scanner.nextDouble();
                    System.out.println("Enter the product quantity:");
                    quantity = scanner.nextInt();
                    inventory.addProduct(name, price, quantity);
                }
                case 2 -> {
                    System.out.println("Enter the product name:");
                    name = scanner.next();
                    System.out.println("Enter the new price:");
                    price = scanner.nextDouble();
                    inventory.updatePrice(name, price);
                }
                case 3 -> {
                    System.out.println("Enter the product name:");
                    name = scanner.next();
                    System.out.println("Enter the new quantity:");
                    quantity = scanner.nextInt();
                    inventory.updateQuantity(name, quantity);
                }
                case 4 -> {
                    System.out.println("Enter the product name:");
                    name = scanner.next();
                    Product product = inventory.searchProduct(name);
                    if (product != null) {
                        System.out.println("Product Name: " + name);
                        System.out.println("Price: " + product.getPrice());
                        System.out.println("Quantity: " + product.getQuantity());
                    } else {
                        System.out.println("Product not found.");
                    }
                }
                case 5 -> inventory.displayInventory();
                case 6 -> exit = true;
                default -> System.out.println("Invalid choice.");
            }
            System.out.println();
        }
        scanner.close();
    }
}
