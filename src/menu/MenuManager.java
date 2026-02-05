package menu;

import Database.PetDAO;
import exception.InvalidInputException;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager implements Menu {
    private final PetDAO petDao = new PetDAO();
    private final ArrayList<Owner> owners = new ArrayList<>();
    private final ArrayList<Appointment> appointments = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public MenuManager() {
        owners.add(new Owner(1, "Alice", "+77011234567"));
    }

    @Override
    public void displayMenu() {
        System.out.println("\n=== VET CLINIC SYSTEM (Week 8) ===");
        System.out.println("1. Add Dog");
        System.out.println("2. Add Cat");
        System.out.println("3. View All Pets");
        System.out.println("4. Update Pet (Name/Age)");
        System.out.println("5. Delete Pet (Safe)");
        System.out.println("6. Search by Name");
        System.out.println("7. Search by Age Range");
        System.out.println("8. Add Owner");
        System.out.println("9. View All Owners");
        System.out.println("10. Add Appointment");
        System.out.println("11. View All Appointments");
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
                    case 4 -> updatePet();
                    case 5 -> deletePet();
                    case 6 -> searchByName();
                    case 7 -> searchByAge();
                    case 8 -> addOwner();
                    case 9 -> viewAllOwners();
                    case 10 -> addAppointment();
                    case 11 -> viewAllAppointments();
                    case 0 -> {
                        running = false;
                        System.out.println("Exiting Vet Clinic System. Goodbye!");
                    }
                    default -> System.out.println("Invalid choice.");
                }
            } catch (InvalidInputException e) {
                System.out.println("Input error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
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
        System.out.print("Enter Name: ");
        String name = readNonEmpty("Name");
        System.out.print("Enter Age: ");
        int age = readInt();
        System.out.print("Enter Breed: ");
        String breed = readNonEmpty("Breed");
        petDao.insertPet(name, breed, age, "Miras");
    }

    private void addCat() throws InvalidInputException {
        System.out.println("\n--- ADD CAT ---");
        System.out.print("Enter Name: ");
        String name = readNonEmpty("Name");
        System.out.print("Enter Age: ");
        int age = readInt();
        System.out.print("Is Vaccinated? (true/false): ");
        boolean isVaccinated = readBoolean();
        petDao.insertPet(name, "Cat", age, "Miras");
    }

    private void viewAllPets() {
        petDao.getAllPets();
    }

    private void updatePet() throws InvalidInputException {
        System.out.println("\n--- UPDATE PET ---");
        System.out.print("Enter ID of pet to update: ");
        int id = readInt();
        System.out.print("Enter new Name: ");
        String name = readNonEmpty("Name");
        System.out.print("Enter new Age: ");
        int age = readInt();

        if (petDao.updatePet(id, name, age)) {
            System.out.println("Pet updated successfully!");
        } else {
            System.out.println("Pet with ID " + id + " not found.");
        }
    }

    private void deletePet() throws InvalidInputException {
        System.out.println("\n--- SAFE DELETE ---");
        System.out.print("Enter ID of pet to delete: ");
        int id = readInt();

        System.out.print("Are you sure you want to delete ID " + id + "? (yes/no): ");
        String confirm = scanner.nextLine().trim().toLowerCase();

        if (confirm.equals("yes")) {
            if (petDao.deletePet(id)) {
                System.out.println("Pet deleted successfully.");
            } else {
                System.out.println("Pet with ID " + id + " not found.");
            }
        } else {
            System.out.println("Deletion cancelled.");
        }
    }

    private void searchByName() throws InvalidInputException {
        System.out.println("\n--- SEARCH BY NAME ---");
        System.out.print("Enter name to search: ");
        String name = readNonEmpty("Search name");
        petDao.searchByName(name);
    }

    private void searchByAge() throws InvalidInputException {
        System.out.println("\n--- SEARCH BY AGE RANGE ---");
        System.out.print("Enter min age: ");
        int min = readInt();
        System.out.print("Enter max age: ");
        int max = readInt();
        petDao.searchByAgeRange(min, max);
    }

    private void addOwner() throws InvalidInputException {
        System.out.println("\n--- ADD NEW OWNER ---");
        System.out.print("Enter ID: ");
        int id = readInt();
        System.out.print("Enter Name: ");
        String name = readNonEmpty("Name");
        System.out.print("Enter Phone Number: ");
        String phone = readNonEmpty("Phone");
        owners.add(new Owner(id, name, phone));
    }

    private void viewAllOwners() {
        System.out.println("\n--- LIST OF OWNERS ---");
        if (owners.isEmpty()) System.out.println("No owners.");
        else owners.forEach(System.out::println);
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
    }

    private void viewAllAppointments() {
        System.out.println("\n--- APPOINTMENTS ---");
        if (appointments.isEmpty()) System.out.println("No appointments.");
        else appointments.forEach(System.out::println);
    }
}