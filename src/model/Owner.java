package model;

public class Owner {
    private int id;
    private String name;
    private String phoneNumber;

    public Owner(int id, String name, String phoneNumber) {
        setId(id);
        setName(name);
        setPhoneNumber(phoneNumber);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }

    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("Owner ID must be positive");
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Owner name cannot be empty");
        this.name = name.trim();
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty())
            throw new IllegalArgumentException("Phone number cannot be empty");
        this.phoneNumber = phoneNumber.trim();
    }

    @Override
    public String toString() {
        return "Owner [ID=" + id + ", Name=" + name + ", Phone=" + phoneNumber + "]";
    }
}
