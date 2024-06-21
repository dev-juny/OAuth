package kr.co.findingall.common.push;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;

public class FCMInitializer {
    public static void initialize() {
        if(FirebaseApp.getApps().isEmpty()) {
            try(FileInputStream account = new FileInputStream("target/classes/serviceKey.json")){
                FirebaseOptions options = new FirebaseOptions.Builder()
                        .setCredentials(GoogleCredentials.fromStream(account))
                        .build();

                FirebaseApp.initializeApp(options);
            }catch(Exception e) {

            }
        }
    }
}
