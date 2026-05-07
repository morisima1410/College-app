package com.example.projectexpo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashScreen extends AppCompatActivity {

    private static final int SPLASH_DELAY = 2000; // 2 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(() -> {
            FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

            if (currentUser != null && !currentUser.isAnonymous()) {
                // Logged-in user
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
            } else {
                // Guest or not logged-in user
                startActivity(new Intent(SplashScreen.this, WelcomeActivity.class));
            }

            finish(); // finish SplashScreen
        }, SPLASH_DELAY);
    }
}
