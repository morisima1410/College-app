package com.example.projectexpo.civil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.projectexpo.R;

public class civilsem2 extends AppCompatActivity {
    Button sem1Summer, sem1Winter, sem2Summer, sem2Winter,
            sem3Summer, sem3Winter, sem4Summer, sem4Winter,
            sem5Summer, sem5Winter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_civilsem2);
        sem1Summer = findViewById(R.id.btnechmSummer);
        sem1Winter = findViewById(R.id.btnechmWinter);

        sem2Summer = findViewById(R.id.btncheSummer);
        sem2Winter = findViewById(R.id.btncheWinter);

        sem3Summer = findViewById(R.id.btnmathsSummer);
        sem3Winter = findViewById(R.id.btnmathsWinter);

        sem4Summer = findViewById(R.id.btnbdSummer);
        sem4Winter = findViewById(R.id.btnbdWinter);


        sem1Summer.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/S2018/DI/3300003.pdf"));
        sem1Winter.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/W2018/DI/3300003.pdf"));

        sem2Summer.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/S2023/DI/4300009.pdf"));
        sem2Winter.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/W2023/DI/4300009.pdf"));

        sem3Summer.setOnClickListener(v -> openLink("https://share.google/RfoQDyZCSLteU50lg"));
        sem3Winter.setOnClickListener(v -> openLink("https://share.google/kgyO4OYBhsO8DdocQ"));

        sem4Summer.setOnClickListener(view -> openLink("https://gtu.ac.in/uploads/S2022/DI/3320601.pdf"));
        sem4Winter.setOnClickListener(view -> openLink("https://gtu.ac.in/uploads/W2022/DI/3320601.pdf"));

    }
    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}