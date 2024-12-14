package RentalPS.services;

import RentalPS.repositories.NotificationRepository;
import java.time.LocalDateTime;

public class NotificationService {
    private NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    // Menambahkan notifikasi untuk rental tertentu
    public void addNotification(int rentalId, LocalDateTime rentalEndTime) {
        notificationRepository.addNotification(rentalId, rentalEndTime);
    }

    // Menghapus notifikasi terkait rental yang sudah dihapus
    public void removeNotification(int rentalId) {
        notificationRepository.removeNotification(rentalId);
    }

    // Menampilkan notifikasi berdasarkan rental ID
    public void displayNotification(int rentalId) {
        notificationRepository.displayNotification(rentalId);
    }
}