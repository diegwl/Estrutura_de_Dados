import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookstoreInventory {
    private Map<String, Book> books;
    private Scanner scanner;

    public BookstoreInventory() {
        books = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void start() {
        int choice = -1;

        while (choice != 0) {
            System.out.println("Select an option:");
            System.out.println("1. Add a book");
            System.out.println("2. Update a book");
            System.out.println("3. Search for a book");
            System.out.println("4. Display inventory");
            System.out.println("0. Exit");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    updateBook();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    displayInventory();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }

            System.out.println();
        }
    }

    private void addBook() {
        System.out.println("Enter the book title:");
        String title = scanner.nextLine();

        System.out.println("Enter the author:");
        String author = scanner.nextLine();

        System.out.println("Enter the genre:");
        String genre = scanner.nextLine();

        System.out.println("Enter the price:");
        double price = scanner.nextDouble();

        books.put(title, new Book(title, author, genre, price));

        System.out.println("Book added!");
    }

    private void updateBook() {
        System.out.println("Enter the book title:");
        String title = scanner.nextLine();

        if (books.containsKey(title)) {
            System.out.println("Enter the new author (press enter to keep the current value):");
            String author = scanner.nextLine().trim();

            System.out.println("Enter the new genre (press enter to keep the current value):");
            String genre = scanner.nextLine().trim();

            System.out.println("Enter the new price (press enter to keep the current value):");
            String priceString = scanner.nextLine().trim();
            double price = -1;

            if (!priceString.isEmpty()) {
                try {
                    price = Double.parseDouble(priceString);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid price format!");
                    return;
                }
            }

            Book book = books.get(title);

            if (!author.isEmpty()) {
                book.setAuthor(author);
            }

            if (!genre.isEmpty()) {
                book.setGenre(genre);
            }

            if (price >= 0) {
                book.setPrice(price);
            }

            System.out.println("Book updated!");
        } else {
            System.out.println("Book not found!");
        }
    }

    private void searchBook() {
        System.out.println("Enter the book title:");
        String title = scanner.next();

        if (books.containsKey(title)) {
            System.out.println(books.get(title));
        } else {
            System.out.println("Book not found!");
        }
    }

    private void displayInventory() {
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    private static class Book {
        private String title;
        private String author;
        private String genre;
        private double price;

        public Book(String title, String author, String genre, double price) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.price = price;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Title: " + title + "\nAuthor: " + author + "\nGenre: " + genre + "\nPrice: $" + price;
        }
    }

    public static void main(String[] args) {
        BookstoreInventory bookstoreInventory = new BookstoreInventory();
        bookstoreInventory.start();
    }
}
