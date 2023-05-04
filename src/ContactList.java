import java.util.ArrayList;
import java.util.Scanner;
public class ContactList {

    private final ArrayList<String> contacts;

    public ContactList() {
        contacts = new ArrayList<String>();
    }

    public void addContact(String contact) {
        contacts.add(contact);
    }

    public void removeContact(String contact) {
        contacts.remove(contact);
    }

    public void searchContacts(String search) {
        for (String contact : contacts) {
            if (contact.contains(search)) {
                System.out.println(contact);
            }
        }
    }

    public void displayContacts() {
        for (String contact : contacts) {
            System.out.println(contact);
        }
    }

    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        Scanner scanner = new Scanner(System.in);
        label:
        while (true) {
            System.out.println("Enter a command (add, remove, search, display, or quit): ");
            String command = scanner.nextLine();
            switch (command) {
                case "add": {
                    System.out.println("Enter a contact name: ");
                    String contact = scanner.nextLine();
                    contactList.addContact(contact);
                    break;
                }
                case "remove": {
                    System.out.println("Enter a contact name: ");
                    String contact = scanner.nextLine();
                    contactList.removeContact(contact);
                    break;
                }
                case "search":
                    System.out.println("Enter a search term: ");
                    String search = scanner.nextLine();
                    contactList.searchContacts(search);
                    break;
                case "display":
                    contactList.displayContacts();
                    break;
                case "quit":
                    break label;
            }
        }
        scanner.close();
    }
}