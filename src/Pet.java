public class Pet {
    private int id;
    private String name;
    private String species;
    private int age;

    public Pet(int id, String name, String species, int age) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.age = age;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getSpecies() { return species; }
    public int getAge() { return age; }

    public void setName(String name) { this.name = name; }
    public void setSpecies(String species) { this.species = species; }
    public void setAge(int age) { this.age = age; }

    // 2 метода с логикой
    public boolean isAdult() {
        return age >= 1;
    }

    public void celebrateBirthday() {
        this.age++;
    }

    @Override
    public String toString() {
        return "Pet{id=" + id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", age=" + age +
                '}';
    }
}
