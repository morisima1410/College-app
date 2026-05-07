package com.example.projectexpo.mechanical;

import android.annotation.SuppressLint;
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

public class Mecsem4 extends AppCompatActivity {
    Button sem1Summer, sem1Winter, sem2Summer, sem2Winter,
            sem3Summer, sem3Winter, sem4Summer, sem4Winter, sem5Summer, sem5Winter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mecsem4);
        sem1Summer = findViewById(R.id.mecSummerSub1_4);
        sem1Winter = findViewById(R.id.mecWinterSub1_4);

        sem2Summer = findViewById(R.id.mecSummerSub2_4);
        sem2Winter = findViewById(R.id.mecSummerSub2_4);

        sem3Summer = findViewById(R.id.mecSummerSub3_4);
        sem3Winter = findViewById(R.id.mecSummerSub3_4);

        sem4Summer = findViewById(R.id.mecSummerSub4_4);
        sem4Winter = findViewById(R.id.mecSummerSub4_4);

        sem5Summer = findViewById(R.id.mecSummerSub5_4);
        sem5Winter = findViewById(R.id.mecSummerSub5_4);

        sem1Summer.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/S2024/DI/4341901.pdf"));
        sem1Winter.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/W2024/DI/4341901.pdf"));

        sem2Summer.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/S2024/DI/4341902.pdf"));
        sem2Winter.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/W2024/DI/4341902.pdf"));

        sem3Summer.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/S2024/DI/4341903.pdf"));
        sem3Winter.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/W2024/DI/4341903.pdf"));

        sem4Summer.setOnClickListener(view -> openLink("https://gtu.ac.in/uploads/S2024/DI/4341904.pdf"));
        sem4Winter.setOnClickListener(view -> openLink("https://gtu.ac.in/uploads/W2024/DI/4341904.pdf"));

        sem5Summer.setOnClickListener(view -> openLink("https://gtu.ac.in/uploads/S2023/DI/4341905.pdf"));
        sem5Winter.setOnClickListener(view -> openLink("https://gtu.ac.in/uploads/W2024/DI/4341905.pdf"));
    }

    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

}
