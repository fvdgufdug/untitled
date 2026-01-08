public class Cat extends Pet {
    private boolean isVaccinated;

    public Cat(int id, String name, int age, boolean isVaccinated) {
        super(id, name, "Cat", age);
        this.isVaccinated = isVaccinated;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    @Override
    public void makeSound() {
        System.out.println("Cat " + name + " says: Meow...");
    }

    public void purr() {
        System.out.println(name + " is purring happily.");
    }

    @Override
    public String toString() {
        return super.toString() + " | Vaccinated: " + (isVaccinated ? "Yes" : "No");
    }
}
