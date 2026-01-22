package menu;

import exception.InvalidInputException;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager implements Menu {
    private final ArrayList<Pet> pets = new ArrayList<>();
    private final ArrayList<Owner> owners = new ArrayList<>();
    private final ArrayList<Appointment> appointments = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public MenuManager() {
        pets.add(new Dog(1, "Rex", 5, "German Shepherd"));
        pets.add(new Cat(2, "Luna", 3, true));
        owners.add(new Owner(1, "Alice", "+77011234567"));
    }

    @Override
    public void displayMenu() {
        System.out.println("\n=== VET CLINIC SYSTEM (Week 6) ===");
        System.out.println("1. Add Dog");
        System.out.println("2. Add Cat");
        System.out.println("3. View All Pets");
        System.out.println("4. Make All Pets Sound (Polymorphism)");
        System.out.println("5. View Dogs Only");
        System.out.println("6. Add Owner");
        System.out.println("7. View All Owners");
        System.out.println("8. Add Appointment");
        System.out.println("9. View All Appointments");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();

            try {
                int choice = readInt();

                switch (choice) {
                    case 1 -> addDog();
                    case 2 -> addCat();
                    case 3 -> viewAllPets();
                    case 4 -> makePetsSound();
                    case 5 -> viewDogsOnly();
                    case 6 -> addOwner();
                    case 7 -> viewAllOwners();
                    case 8 -> addAppointment();
                    case 9 -> viewAllAppointments();
                    case 0 -> {
                        running = false;
                        System.out.println("Exiting Vet Clinic System. Goodbye!");
                    }
                    default -> System.out.println("Invalid choice.");
                }

            } catch (InvalidInputException e) {
                System.out.println("Input error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Validation error: " + e.getMessage());
            }
        }
    }

    private int readInt() throws InvalidInputException {
        String s = scanner.nextLine().trim();
        if (s.isEmpty()) throw new InvalidInputException("Number is required");
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Please enter a valid integer");
        }
    }

    private boolean readBoolean() throws InvalidInputException {
        String s = scanner.nextLine().trim().toLowerCase();
        if (s.equals("true")) return true;
        if (s.equals("false")) return false;
        throw new InvalidInputException("Enter true or false");
    }

    private String readNonEmpty(String field) throws InvalidInputException {
        String s = scanner.nextLine().trim();
        if (s.isEmpty()) throw new InvalidInputException(field + " cannot be empty");
        return s;
    }

    private void addDog() throws InvalidInputException {
        System.out.println("\n--- ADD DOG ---");
        System.out.print("Enter ID: ");
        int id = readInt();

        System.out.print("Enter Name: ");
        String name = readNonEmpty("Name");

        System.out.print("Enter Age: ");
        int age = readInt();

        System.out.print("Enter Breed: ");
        String breed = readNonEmpty("Breed");

        pets.add(new Dog(id, name, age, breed));
        System.out.println("Dog added successfully!");
    }

    private void addCat() throws InvalidInputException {
        System.out.println("\n--- ADD CAT ---");
        System.out.print("Enter ID: ");
        int id = readInt();

        System.out.print("Enter Name: ");
        String name = readNonEmpty("Name");

        System.out.print("Enter Age: ");
        int age = readInt();

        System.out.print("Is Vaccinated? (true/false): ");
        boolean isVaccinated = readBoolean();

        pets.add(new Cat(id, name, age, isVaccinated));
        System.out.println("Cat added successfully!");
    }

    private void viewAllPets() {
        System.out.println("\n--- LIST OF PETS ---");
        if (pets.isEmpty()) System.out.println("No pets registered yet.");
        else for (Pet p : pets) System.out.println(p);
    }

    private void makePetsSound() {
        System.out.println("\n--- PET SOUNDS ---");
        if (pets.isEmpty()) System.out.println("No pets found.");
        else for (Pet p : pets) p.makeSound();
    }

    private void viewDogsOnly() {
        System.out.println("\n--- DOGS ONLY ---");
        boolean found = false;
        for (Pet p : pets) {
            if (p instanceof Dog dog) {
                System.out.println(dog);
                dog.guardHouse();
                found = true;
            }
        }
        if (!found) System.out.println("No dogs found.");
    }

    private void addOwner() throws InvalidInputException {
        System.out.println("\n--- ADD NEW OWNER ---");
        System.out.print("Enter Owner ID: ");
        int id = readInt();

        System.out.print("Enter Name: ");
        String name = readNonEmpty("Name");

        System.out.print("Enter Phone Number: ");
        String phone = readNonEmpty("Phone number");

        owners.add(new Owner(id, name, phone));
        System.out.println("Owner added successfully!");
    }

    private void viewAllOwners() {
        System.out.println("\n--- LIST OF OWNERS ---");
        if (owners.isEmpty()) System.out.println("No owners registered.");
        else for (Owner o : owners) System.out.println(o);
    }

    private void addAppointment() throws InvalidInputException {
        System.out.println("\n--- ADD APPOINTMENT ---");
        System.out.print("Enter ID: ");
        int id = readInt();

        System.out.print("Enter Pet Name: ");
        String petName = readNonEmpty("Pet name");

        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = readNonEmpty("Date");

        System.out.print("Enter Reason: ");
        String reason = readNonEmpty("Reason");

        appointments.add(new Appointment(id, petName, date, reason));
        System.out.println("Appointment scheduled!");
    }

    private void viewAllAppointments() {
        System.out.println("\n--- APPOINTMENTS ---");
        if (appointments.isEmpty()) System.out.println("No appointments scheduled.");
        else for (Appointment a : appointments) System.out.println(a);
    }
}
