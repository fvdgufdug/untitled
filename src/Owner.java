public class Owner {
    private int id;
    private String name;
    private String phone;
    private int petsCount;

    public Owner(int id, String name, String phone, int petsCount) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.petsCount = petsCount;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public int getPetsCount() { return petsCount; }

    public void setName(String name) { this.name = name; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setPetsCount(int petsCount) { this.petsCount = petsCount; }

    // 2 метода с логикой
    public void addPet() {
        petsCount++;
    }

    public boolean hasManyPets() {
        return petsCount >= 3;
    }

    @Override
    public String toString() {
        return "Owner{id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", petsCount=" + petsCount +
                '}';
    }
}
