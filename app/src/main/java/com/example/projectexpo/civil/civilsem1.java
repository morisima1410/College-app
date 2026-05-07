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

public class civilsem1 extends AppCompatActivity {
    Button sem1Summer, sem1Winter, sem2Summer, sem2Winter,
            sem3Summer, sem3Winter, sem4Summer, sem4Winter,
            sem5Summer, sem5Winter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_civilsem1);

        sem1Summer = findViewById(R.id.btnmathSummer);
        sem1Winter = findViewById(R.id.btnmathWinter);

        sem2Summer = findViewById(R.id.btnEngSummer);
        sem2Winter = findViewById(R.id.btnEngWinter);

        sem3Summer = findViewById(R.id.btnPhySummer);
        sem3Winter = findViewById(R.id.btnPhyWinter);

        sem4Summer = findViewById(R.id.btnbedSummer);
        sem4Winter = findViewById(R.id.btnbedWinter);




        sem1Summer.setOnClickListener(v -> openLink("https://share.google/LMcVPDUEkm3zmVvHp"));
        sem1Winter.setOnClickListener(v -> openLink("https://share.google/rabbX5dGZowbc07Br"));

        sem2Summer.setOnClickListener(v -> openLink("https://share.google/hwAY4dlZdI8JH9S3r"));
        sem2Winter.setOnClickListener(v -> openLink("https://share.google/8oiLKC1USqXwexqwo"));

        sem3Summer.setOnClickListener(v -> openLink("https://share.google/BT8MMDNLRl9HKLrRZ"));
        sem3Winter.setOnClickListener(v -> openLink("https://share.google/KW4PCAWkMNajbAxjr"));

        sem4Summer.setOnClickListener(view -> openLink("https://gtu.ac.in/uploads/S2019/DI/3300007.pdf"));
        sem4Winter.setOnClickListener(view -> openLink("https://gtu.ac.in/uploads/W2019/DI/3300007.pdf"));



    }

    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}