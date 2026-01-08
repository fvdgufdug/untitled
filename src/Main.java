import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Pet> pets = new ArrayList<>();
    private static ArrayList<Owner> owners = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        pets.add(new Dog(1, "Rex", 5, "German Shepherd"));
        pets.add(new Cat(2, "Luna", 3, true));
        owners.add(new Owner(1, "Alice", "+77011234567"));

        boolean running = true;

        while (running) {
            printMenu();
            int choice = 0;

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    addDog();
                    break;
                case 2:
                    addCat();
                    break;
                case 3:
                    viewAllPets();
                    break;
                case 4:
                    makePetsSound();
                    break;
                case 5:
                    viewDogsOnly();
                    break;
                case 6:
                    addOwner();
                    break;
                case 7:
                    viewAllOwners();
                    break;
                case 8:
                    addAppointment();
                    break;
                case 9:
                    viewAllAppointments();
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting Vet Clinic System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n=== VET CLINIC SYSTEM (Week 4) ===");
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

    private static void addDog() {
        System.out.println("\n--- ADD DOG ---");
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Breed: ");
        String breed = scanner.nextLine();

        pets.add(new Dog(id, name, age, breed));
        System.out.println("Dog added successfully!");
    }

    private static void addCat() {
        System.out.println("\n--- ADD CAT ---");
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Is Vaccinated? (true/false): ");
        boolean isVaccinated = scanner.nextBoolean();
        scanner.nextLine();

        pets.add(new Cat(id, name, age, isVaccinated));
        System.out.println("Cat added successfully!");
    }

    private static void viewAllPets() {
        System.out.println("\n--- LIST OF PETS ---");
        if (pets.isEmpty()) {
            System.out.println("No pets registered yet.");
        } else {
            for (Pet p : pets) {
                System.out.println(p);
            }
        }
    }

    private static void makePetsSound() {
        System.out.println("\n--- PET SOUNDS ---");
        if (pets.isEmpty()) {
            System.out.println("No pets found.");
        } else {
            for (Pet p : pets) {
                p.makeSound();
            }
        }
    }

    private static void viewDogsOnly() {
        System.out.println("\n--- DOGS ONLY ---");
        boolean found = false;
        for (Pet p : pets) {
            if (p instanceof Dog) {
                Dog dog = (Dog) p;
                System.out.println(dog);
                dog.guardHouse();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No dogs found.");
        }
    }

    private static void addOwner() {
        System.out.println("\n--- ADD NEW OWNER ---");
        System.out.print("Enter Owner ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();

        owners.add(new Owner(id, name, phone));
        System.out.println("Owner added successfully!");
    }

    private static void viewAllOwners() {
        System.out.println("\n--- LIST OF OWNERS ---");
        if (owners.isEmpty()) {
            System.out.println("No owners registered.");
        } else {
            for (Owner o : owners) {
                System.out.println(o);
            }
        }
    }

    private static void addAppointment() {
        System.out.println("\n--- ADD APPOINTMENT ---");
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Pet Name: ");
        String petName = scanner.nextLine();

        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        System.out.print("Enter Reason: ");
        String reason = scanner.nextLine();

        appointments.add(new Appointment(id, petName, date, reason));
        System.out.println("Appointment scheduled!");
    }

    private static void viewAllAppointments() {
        System.out.println("\n--- APPOINTMENTS ---");
        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
        } else {
            for (Appointment a : appointments) {
                System.out.println(a);
            }
        }
    }
}
