import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

class Guest {
    private String name;
    private boolean confirmado;

    public Guest(String name) {
        this.name = name;
        this.confirmado = false;
    }

    public String getName() {
        return name;
    }

    public boolean getConfirmado() {
        return confirmado;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }
}

public class EventRSVP {
    private Set<Guest> guests = new HashSet<>();
    private Scanner scanner = new Scanner(System.in);

    public void addGuest(String name) {
        guests.add(new Guest(name));
    }

    public void removeGuest(String name) {
        for (Guest guest : guests) {
            if (guest.getName().equals(name)) {
                guests.remove(guest);
                System.out.println(name + " has been removed from the guest list.");
                return;
            }
        }
        System.out.println(name + " was not found in the guest list.");
    }

    public boolean hasRSVP(String name) {
        for (Guest guest : guests) {
            if (guest.getName().equals(name)) {
                return guest.getConfirmado();
            }
        }
        return false;
    }

    public void setRSVP(String name, boolean rsvp) {
        for (Guest guest : guests) {
            if (guest.getName().equals(name)) {
                guest.setConfirmado(rsvp);
                System.out.println(name + " has " + (rsvp ? "RSVPed" : "cancelled their RSVP") + ".");
                return;
            }
        }
        System.out.println(name + " was not found in the guest list.");
    }

    public void displayConfirmedGuests() {
        System.out.println("Confirmed Guests:");
        for (Guest guest : guests) {
            if (guest.getConfirmado()) {
                System.out.println(guest.getName());
            }
        }
    }

    public void displayMenu() {
        System.out.println("Event RSVP Menu");
        System.out.println("1. Add Guest");
        System.out.println("2. Remove Guest");
        System.out.println("3. Check RSVP");
        System.out.println("4. Set RSVP");
        System.out.println("5. Display Confirmed Guests");
        System.out.println("6. Exit");
    }

    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter guest name: ");
                    String name = scanner.nextLine();
                    addGuest(name);
                    break;
                case 2:
                    System.out.print("Enter guest name: ");
                    name = scanner.nextLine();
                    removeGuest(name);
                    break;
                case 3:
                    System.out.print("Enter guest name: ");
                    name = scanner.nextLine();
                    if (hasRSVP(name)) {
                        System.out.println(name + " has RSVPed.");
                    } else {
                        System.out.println(name + " has not RSVPed.");
                    }
                    break;
                case 4:
                    System.out.print("Enter guest name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter RSVP status (true/false): ");
                    boolean rsvp = scanner.nextBoolean();
                    scanner.nextLine();
                    setRSVP(name, rsvp);
                    break;
                case 5:
                    displayConfirmedGuests();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        EventRSVP eventRSVP = new EventRSVP();
        eventRSVP.run();
    }
}