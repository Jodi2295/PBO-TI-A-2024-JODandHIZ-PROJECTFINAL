package RentalPS.repositories;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class NotificationRepository {
    private Map<Integer, LocalDateTime> notifications = new HashMap<>();

    // Menambahkan notifikasi untuk rental tertentu
    public void addNotification(int rentalId, LocalDateTime rentalEndTime) {
        notifications.put(rentalId, rentalEndTime);
    }

    // Menghapus notifikasi berdasarkan rental ID
    public void removeNotification(int rentalId) {
        notifications.remove(rentalId);
    }

    // Menampilkan notifikasi untuk rental ID tertentu
    public void displayNotification(int rentalId) {
        LocalDateTime endTime = notifications.get(rentalId);
        if (endTime != null) {
            System.out.println("Rental ID: " + rentalId + " akan berakhir pada: " + endTime);
        } else {
            System.out.println("Tidak ada notifikasi untuk rental ID: " + rentalId);
        }
    }
}