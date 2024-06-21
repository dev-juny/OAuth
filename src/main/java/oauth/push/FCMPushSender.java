package kr.co.findingall.common.push;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

public class FCMPushSender {
    public static void sendPushNotification(String token, String title, String body) {
        // Create the notification
        Notification notification = Notification.builder()
                .setTitle(title)
                .setBody(body)
                .build();

        // Create the message
        Message message = Message.builder()
                .setToken(token)
                .setNotification(notification)
                .build();

        // Send the message
        try {
            String response = FirebaseMessaging.getInstance().send(message);
            System.out.println("Successfully sent message: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}