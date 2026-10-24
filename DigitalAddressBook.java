
import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phone;
    String email;
    String address;
    String category;

    Contact(String name, String phone, String email,
            String address, String category) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.category = category;
    }

    void display() {
        System.out.println("\nName     : " + name);
        System.out.println("Phone    : " + phone);
        System.out.println("Email    : " + email);
        System.out.println("Address  : " + address);
        System.out.println("Category : " + category);
        System.out.println("------------------------------");
    }
}

public class DigitalAddressBook {

    static ArrayList<Contact> contacts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addContact() {
        System.out.println("\n--- Add New Contact ---");

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter address: ");
        String address = sc.nextLine();

        System.out.println("Categories: Family, Friends, College, Work, Other");
        System.out.print("Enter category: ");
        String category = sc.nextLine();

        contacts.add(new Contact(name, phone, email, address, category));

        System.out.println("Contact added successfully!");
    }

    static void viewContacts() {
        System.out.println("\n--- All Contacts ---");

        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        for (Contact c : contacts) {
            c.display();
        }
    }

    static void searchContact() {
        System.out.print("\nEnter name or phone to search: ");
        String key = sc.nextLine().toLowerCase();

        boolean found = false;

        for (Contact c : contacts) {
            if (c.name.toLowerCase().contains(key)
                    || c.phone.contains(key)) {
                c.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    static void categorizeContacts() {
        System.out.print("\nEnter category to view: ");
        String category = sc.nextLine();

        boolean found = false;

        for (Contact c : contacts) {
            if (c.category.equalsIgnoreCase(category)) {
                c.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No contacts in this category.");
        }
    }

    static void updateContact() {
        System.out.print("\nEnter phone number of contact to update: ");
        String phone = sc.nextLine();

        for (Contact c : contacts) {
            if (c.phone.equals(phone)) {
                System.out.print("Enter new name: ");
                c.name = sc.nextLine();

                System.out.print("Enter new phone number: ");
                c.phone = sc.nextLine();

                System.out.print("Enter new email: ");
                c.email = sc.nextLine();

                System.out.print("Enter new address: ");
                c.address = sc.nextLine();

                System.out.print("Enter new category: ");
                c.category = sc.nextLine();

                System.out.println("Contact updated successfully!");
                return;
            }
        }

        System.out.println("Contact not found.");
    }

    static void deleteContact() {
        System.out.print("\nEnter phone number to delete: ");
        String phone = sc.nextLine();

        for (Contact c : contacts) {
            if (c.phone.equals(phone)) {
                contacts.remove(c);
                System.out.println("Contact deleted successfully!");
                return;
            }
        }

        System.out.println("Contact not found.");
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n================================");
            System.out.println("     DIGITAL ADDRESS BOOK");
            System.out.println("================================");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. View Contacts by Category");
            System.out.println("5. Update Contact");
            System.out.println("6. Delete Contact");
            System.out.println("7. Exit");
            System.out.println("================================");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        addContact();
                        break;

                    case 2:
                        viewContacts();
                        break;

                    case 3:
                        searchContact();
                        break;

                    case 4:
                        categorizeContacts();
                        break;

                    case 5:
                        updateContact();
                        break;

                    case 6:
                        deleteContact();
                        break;

                    case 7:
                        System.out.println("Thank you for using Digital Address Book!");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid menu number.");
                choice = 0;
            }

        } while (choice != 7);

        sc.close();
    }
}
