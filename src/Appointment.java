public class Appointment {
    private int id;
    private String petName;
    private String date;
    private String reason;

    public Appointment(int id, String petName, String date, String reason) {
        this.id = id;
        setPetName(petName);
        this.date = date;
        setReason(reason);
    }

    public void setPetName(String petName) {
        if (petName != null && !petName.isEmpty()) {
            this.petName = petName;
        } else {
            this.petName = "Unknown Pet";
        }
    }

    public void setReason(String reason) {
        if (reason != null && !reason.isEmpty()) {
            this.reason = reason;
        } else {
            this.reason = "General Checkup";
        }
    }

    @Override
    public String toString() {
        return "Appointment [ID=" + id + ", Pet=" + petName + ", Date=" + date + ", Reason=" + reason + "]";
    }
}
