package RentalPS.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Notification {
    private int rentalId;
    private LocalDateTime rentalEndTime;

    public Notification(int rentalId, LocalDateTime rentalEndTime) {
        this.rentalId = rentalId;
        this.rentalEndTime = rentalEndTime;
    }

    public int getRentalId() {
        return rentalId;
    }

    public LocalDateTime getRentalEndTime() {
        return rentalEndTime;
    }

    @Override
    public String toString() {
        // Format waktu agar rapi
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Rental ID: " + rentalId + " akan berakhir pada: " + rentalEndTime.format(formatter);
    }
}