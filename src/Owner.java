public class Owner {
    private int id;
    private String name;
    private String phoneNumber;

    public Owner(int id, String name, String phoneNumber) {
        this.id = id;
        setName(name);
        setPhoneNumber(phoneNumber);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }

    public void setId(int id) { this.id = id; }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Error: Owner name cannot be empty.");
            this.name = "Unknown Owner";
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && !phoneNumber.trim().isEmpty()) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Error: Phone number cannot be empty.");
            this.phoneNumber = "No Phone";
        }
    }

    @Override
    public String toString() {
        return "Owner [ID=" + id + ", Name=" + name + ", Phone=" + phoneNumber + "]";
    }
}
