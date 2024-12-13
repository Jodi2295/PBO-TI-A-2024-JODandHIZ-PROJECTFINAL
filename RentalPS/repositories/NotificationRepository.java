package RentalPS.repositories;

import RentalPS.entities.Notification;
import java.util.ArrayList;
import java.util.List;

public class NotificationRepository {
    private List<Notification> notifications = new ArrayList<>();

    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public List<Notification> getNotificationsForUser(String username) {
        List<Notification> userNotifications = new ArrayList<>();
        for (Notification notification : notifications) {
            if (notification.getUsername().equals(username)) {
                userNotifications.add(notification);
            }
        }
        return userNotifications;
    }
}
