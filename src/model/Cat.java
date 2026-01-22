package model;

import interfaces.Vaccinable;

public class Cat extends Pet implements Vaccinable {
    private boolean vaccinated;

    public Cat(int id, String name, int age, boolean vaccinated) {
        super(id, name, "Cat", age);
        this.vaccinated = vaccinated;
    }

    @Override
    public boolean isVaccinated() {
        return vaccinated;
    }

    @Override
    public void vaccinate() {
        this.vaccinated = true;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
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
        return super.toString() + " | Vaccinated: " + (vaccinated ? "Yes" : "No");
    }
}
