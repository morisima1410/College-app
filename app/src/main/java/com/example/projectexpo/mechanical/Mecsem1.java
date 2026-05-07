package com.example.projectexpo.mechanical;

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

public class Mecsem1 extends AppCompatActivity {

    Button sem1Summer, sem1Winter, sem2Summer, sem2Winter,
            sem3Summer, sem3Winter, sem4Summer, sem4Winter, sem5Summer, sem5Winter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mecsem1);

        sem1Summer = findViewById(R.id.mecSummerSub1_1);
        sem1Winter = findViewById(R.id.mecWinterSub1_1);

        sem2Summer = findViewById(R.id.mecSummerSub2_1);
        sem2Winter = findViewById(R.id.mecSummerSub2_1);

        sem3Summer = findViewById(R.id.mecSummerSub3_1);
        sem3Winter = findViewById(R.id.mecSummerSub3_1);

        sem4Summer = findViewById(R.id.mecSummerSub4_1);
        sem4Winter = findViewById(R.id.mecSummerSub4_1);

//        sem5Summer = findViewById(R.id.mecSummerSub5_1);
//        sem5Winter = findViewById(R.id.mecSummerSub5_1);

        sem1Summer.setOnClickListener(v -> openLink("https://share.google/RfoQDyZCSLteU50lg"));
        sem1Winter.setOnClickListener(v -> openLink("https://share.google/kgyO4OYBhsO8DdocQ"));

        sem2Summer.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/S2025/DI/DI000031.pdf"));
        sem2Winter.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/W2024/DI/DI01000031.pdf"));

        sem3Summer.setOnClickListener(v -> openLink("https://www.gtu.ac.in/uploads/S2022/DI/4300004.pdf"));
        sem3Winter.setOnClickListener(v -> openLink("https://www.gtu.ac.in/uploads/W2021/DI/4300004.pdf"));

        sem4Summer.setOnClickListener(view -> openLink("https://www.gtu.ac.in/uploads/S2022/DI/4300007.pdf"));
        sem4Winter.setOnClickListener(view -> openLink("https://www.gtu.ac.in/uploads/W2021/DI/4300007.pdf"));

    }
    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}