package com.example.projectexpo.computer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectexpo.R;

public class Compsem2 extends AppCompatActivity {
    Button sub1Summersem2, sub1Wintersem2, sub2Summersem2, sub2Wintersem2,
            sub3Summersem2, sub3Wintersem2, sub4Summersem2, sub4Wintersem2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_compsem2);
        sub1Summersem2 = findViewById(R.id.subSummer1);
        sub1Wintersem2 = findViewById(R.id.subWinter1);

        sub2Summersem2 = findViewById(R.id.subSummer2);
        sub2Wintersem2 = findViewById(R.id.subWinter2);

        sub3Summersem2 = findViewById(R.id.subSummer3);
        sub3Wintersem2 = findViewById(R.id.subWinter3);

        sub4Summersem2 = findViewById(R.id.subSummer4);
        sub4Wintersem2 = findViewById(R.id.subWinter4);

        sub1Summersem2.setOnClickListener(v -> openLink("https://share.google/viKCoWYflSUnB22fG "));
        sub1Wintersem2.setOnClickListener(v -> openLink("https://share.google/kWfWloJhvf1T0bOEy"));

        sub2Summersem2.setOnClickListener(v -> openLink("https://share.google/RfoQDyZCSLteU50lg"));
        sub2Wintersem2.setOnClickListener(v -> openLink("https://share.google/kgyO4OYBhsO8DdocQ"));

        sub3Summersem2.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2023/04/summer-2022_4320702.pdf"));
        sub3Wintersem2.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2023/04/winter-2022_4320702.pdf"));

        sub4Summersem2.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2023/05/4320703-gtu-paper-2.pdf"));
        sub4Wintersem2.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2023/04/winter-2022_4320702.pdf"));



    }

    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}