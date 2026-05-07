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

public class Mecsem2 extends AppCompatActivity {
    Button sem1Summer, sem1Winter, sem2Summer, sem2Winter,
            sem3Summer, sem3Winter, sem4Summer, sem4Winter, sem5Summer, sem5Winter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mecsem2);
        sem1Summer = findViewById(R.id.mecSummerSub1_2);
        sem1Winter = findViewById(R.id.mecWinterSub1_2);

        sem2Summer = findViewById(R.id.mecSummerSub2_2);
        sem2Winter = findViewById(R.id.mecSummerSub2_2);

        sem3Summer = findViewById(R.id.mecSummerSub3_2);
        sem3Winter = findViewById(R.id.mecSummerSub3_2);

        sem4Summer = findViewById(R.id.mecSummerSub4_2);
        sem4Winter = findViewById(R.id.mecSummerSub4_2);

        sem1Summer.setOnClickListener(v -> openLink("https://www.gtu.ac.in/uploads/S2022/DI/4300003.pdf"));
        sem1Winter.setOnClickListener(v -> openLink("https://www.gtu.ac.in/uploads/W2021/DI/4300003.pdf"));

        sem2Summer.setOnClickListener(v -> openLink("https://www.gtu.ac.in/uploads/S2022/DI/4300008.pdf"));
        sem2Winter.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/W2022/DI/4300008.pdf"));

        sem3Summer.setOnClickListener(v -> openLink("https://www.gtu.ac.in/uploads/S2022/DI/4320001.pdf"));
        sem3Winter.setOnClickListener(v -> openLink("https://www.gtu.ac.in/uploads/w2022/DI/4320001.pdf"));

        sem4Summer.setOnClickListener(view -> openLink("https://www.gtu.ac.in/uploads/S2022/DI/4321902.pdf"));
        sem4Winter.setOnClickListener(view -> openLink("https://gtu.ac.in/uploads/W2023/DI/4321902.pdf"));
    }
    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}