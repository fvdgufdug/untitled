package model;

public abstract class Pet {
    protected int id;
    protected String name;
    protected String species;
    protected int age;

    public Pet(int id, String name, String species, int age) {
        setId(id);
        setName(name);
        setSpecies(species);
        setAge(age);
    }

    public abstract void makeSound();

    public int getId() { return id; }
    public String getName() { return name; }
    public String getSpecies() { return species; }
    public int getAge() { return age; }

    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("Pet ID must be positive");
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Pet name cannot be empty");
        this.name = name.trim();
    }

    public void setSpecies(String species) {
        if (species == null || species.trim().isEmpty())
            throw new IllegalArgumentException("Species cannot be empty");
        this.species = species.trim();
    }

    public void setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Age cannot be negative");
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pet [ID=" + id + ", Name=" + name + ", Species=" + species + ", Age=" + age + "]";
    }
}
