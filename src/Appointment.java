import java.time.LocalDateTime;

public class Appointment {
    private int id;
    private Pet pet;
    private Owner owner;
    private String reason;
    private LocalDateTime dateTime;
    private boolean cancelled;

    public Appointment(int id, Pet pet, Owner owner,
                       String reason, LocalDateTime dateTime) {
        this.id = id;
        this.pet = pet;
        this.owner = owner;
        this.reason = reason;
        this.dateTime = dateTime;
        this.cancelled = false;
    }

    public int getId() { return id; }
    public Pet getPet() { return pet; }
    public Owner getOwner() { return owner; }
    public String getReason() { return reason; }
    public LocalDateTime getDateTime() { return dateTime; }
    public boolean isCancelled() { return cancelled; }

    public void setReason(String reason) { this.reason = reason; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    // 2 метода с логикой
    public void cancel() {
        cancelled = true;
    }

    public void reschedule(LocalDateTime newDateTime) {
        if (!cancelled) {
            this.dateTime = newDateTime;
        }
    }

    @Override
    public String toString() {
        return "Appointment{id=" + id +
                ", pet=" + pet.getName() +
                ", owner=" + owner.getName() +
                ", reason='" + reason + '\'' +
                ", dateTime=" + dateTime +
                ", cancelled=" + cancelled +
                '}';
    }
}
