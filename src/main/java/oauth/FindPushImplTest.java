package kr.co.findingall.common.push.impl;

import kr.co.findingall.common.http.FindHttpClient;
import kr.co.findingall.common.push.FCMInitializer;
import kr.co.findingall.common.push.FCMPushSender;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

public class FindPushImplTest {


    @Test
    @DisplayName("FCM 푸시 성공 테스트")
    public void sendSuccessPushFCM() {

        FCMInitializer fcmInitializer = new FCMInitializer();
        // Initialize Firebase SDK
        fcmInitializer.initialize();

        // Send a push notification
        String registrationToken = "token";

        String title = "Hello";
        String body = "World!";
        FCMPushSender.sendPushNotification(registrationToken, title, body);


    }

    @Test
    @DisplayName("FCM 푸시 실패 테스트")
    public void sendFailPushFCM() {

        FCMInitializer fcmInitializer = new FCMInitializer();
        // Initialize Firebase SDK
        fcmInitializer.initialize();

        // Send a push notification
        String registrationToken = null;

        String title = "Hello";
        String body = "World!";
        FCMPushSender.sendPushNotification(registrationToken, title, body);


    }
}