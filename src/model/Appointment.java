package model;

public class Appointment {
    private int id;
    private String petName;
    private String date;
    private String reason;

    public Appointment(int id, String petName, String date, String reason) {
        setId(id);
        setPetName(petName);
        setDate(date);
        setReason(reason);
    }

    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("Appointment ID must be positive");
        this.id = id;
    }

    public void setPetName(String petName) {
        if (petName == null || petName.trim().isEmpty())
            throw new IllegalArgumentException("Pet name cannot be empty");
        this.petName = petName.trim();
    }

    public void setDate(String date) {
        if (date == null || date.trim().isEmpty())
            throw new IllegalArgumentException("Date cannot be empty");
        this.date = date.trim();
    }

    public void setReason(String reason) {
        if (reason == null || reason.trim().isEmpty())
            throw new IllegalArgumentException("Reason cannot be empty");
        this.reason = reason.trim();
    }

    @Override
    public String toString() {
        return "Appointment [ID=" + id + ", Pet=" + petName + ", Date=" + date + ", Reason=" + reason + "]";
    }
}
