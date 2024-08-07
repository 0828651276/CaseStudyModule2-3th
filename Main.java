import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AloneAirlineSystem system = new AloneAirlineSystem();
        Scanner scanner = new Scanner(System.in);
        Customer customer = null;

        System.out.println(" - Welcome to AloneAirline - Where Love Begins - ");

        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    customer = Customer.register();
                    break;
                case 2:
                    customer = Customer.login();
                    break;
                case 3:
                    System.out.println("Thank you for using AloneAirline!");
                    System.exit(0);
                default:
                    System.out.println("Invite you re-enter your choice ");
            }

            if (customer != null) {
                while (true) {
                    System.out.println("\n1. Book Ticket\n2. Modify Ticket\n3. Delete Ticket\n4. Logout");
                    System.out.print("Choose an option: ");
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (choice) {
                        case 1:
                            system.bookTicket(customer);
                            System.out.println("Booking Ticket successful! Thankyou so much!");
                            break;
                        case 2:
                            system.modifyTicket();
                            System.out.println("Modify Ticket successful!");
                            break;
                        case 3:
                            system.deleteTicket();
                            System.out.println("Delete Ticket successful!");
                            break;
                        case 4:
                            customer = null;
                            System.out.println("Logged out.");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }

                    if (customer == null) {
                        break;
                    }
                }
            }
        }
    }
}
