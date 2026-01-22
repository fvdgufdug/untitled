package model;

public class Dog extends Pet {
    private String breed;

    public Dog(int id, String name, int age, String breed) {
        super(id, name, "Dog", age);
        setBreed(breed);
    }

    public String getBreed() { return breed; }

    public void setBreed(String breed) {
        if (breed == null || breed.trim().isEmpty())
            throw new IllegalArgumentException("Breed cannot be empty");
        this.breed = breed.trim();
    }

    @Override
    public void makeSound() {
        System.out.println("Dog " + name + " says: Woof! Woof!");
    }

    public void guardHouse() {
        System.out.println(name + " is guarding the clinic door.");
    }

    @Override
    public String toString() {
        return super.toString() + " | Breed: " + breed;
    }
}
