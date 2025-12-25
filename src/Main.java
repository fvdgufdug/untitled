import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== OWNERS SECTION ===");
        Owner owner1 = new Owner(1, "Alice", "87070000000", 1);
        System.out.println(owner1);
        owner1.addPet();
        System.out.println("After addPet(): " + owner1);
        System.out.println("Has many pets: " + owner1.hasManyPets());
        System.out.println();

        System.out.println("=== PETS SECTION ===");
        Pet pet1 = new Pet(1, "Buddy", "Dog", 2);
        System.out.println(pet1);
        System.out.println("Is adult: " + pet1.isAdult());
        pet1.celebrateBirthday();
        System.out.println("After birthday: " + pet1);
        System.out.println();

        System.out.println("=== APPOINTMENTS SECTION ===");
        Appointment app1 = new Appointment(
                1,
                pet1,
                owner1,
                "Regular checkup",
                LocalDateTime.of(2025, 1, 15, 10, 0)
        );
        System.out.println(app1);
        app1.reschedule(LocalDateTime.of(2025, 1, 16, 11, 30));
        System.out.println("After reschedule: " + app1);
        app1.cancel();
        System.out.println("After cancel: " + app1);
    }
}
