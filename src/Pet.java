public class Pet {
    protected int id;
    protected String name;
    protected String species;
    protected int age;

    public Pet(int id, String name, String species, int age) {
        this.id = id;
        setName(name);
        setSpecies(species);
        setAge(age);
    }

    public void makeSound() {
        System.out.println(name + " makes a sound.");
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getSpecies() { return species; }
    public int getAge() { return age; }

    public void setId(int id) { this.id = id; }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            this.name = "Unknown";
        }
    }

    public void setSpecies(String species) {
        if (species != null && !species.trim().isEmpty()) {
            this.species = species;
        } else {
            this.species = "Unknown";
        }
    }

    public void setAge(int age) {
        if (age >= 0) this.age = age;
        else this.age = 0;
    }

    @Override
    public String toString() {
        return "Pet [ID=" + id + ", Name=" + name + ", Species=" + species + ", Age=" + age + "]";
    }
}
