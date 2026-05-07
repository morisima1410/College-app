package com.example.projectexpo;   // <-- YOUR package name

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Aboutas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutas);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView tvEmail = findViewById(R.id.tvEmail1);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView tvLinkedIn = findViewById(R.id.tvLinkedIn);

        // Email click
        tvEmail.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:morihardik1410@gmail.com"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Contact from App");
            startActivity(intent);
        });

        // LinkedIn click
        tvLinkedIn.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.linkedin.com/in/sima-mori-a0102a349"));
            startActivity(intent);
        });
    }
}
