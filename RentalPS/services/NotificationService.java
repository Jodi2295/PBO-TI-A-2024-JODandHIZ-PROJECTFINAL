package RentalPS.services;

import RentalPS.entities.Notification;
import RentalPS.repositories.NotificationRepository;
import java.util.List;

public class NotificationService {
    private NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    // Menampilkan notifikasi untuk pengguna tertentu
    public void displayNotifications(String username) {
        List<Notification> notifications = notificationRepository.getNotificationsForUser(username);

        if (notifications.isEmpty()) {
            System.out.println("Tidak ada notifikasi untuk pengguna " + username);
        } else {
            System.out.println("Notifikasi untuk " + username + ":");
            for (Notification notification : notifications) {
                System.out.println(notification.getMessage());
            }
        }
    }

    // Metode lain untuk menambahkan notifikasi
    public void addNotification(String username, String message) {
        Notification notification = new Notification(username, message);
        notificationRepository.addNotification(notification);
    }
}