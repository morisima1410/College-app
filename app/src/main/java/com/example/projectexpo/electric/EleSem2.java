package com.example.projectexpo.electric;

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

public class EleSem2 extends AppCompatActivity {
    Button sem1Summer, sem1Winter, sem2Summer, sem2Winter,
            sem3Summer, sem3Winter, sem4Summer, sem4Winter, sem5Summer, sem5Winter, sem6Summer, sem6Winter, sem7Summer, sem7Winter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ele_sem2);
        sem1Summer = findViewById(R.id.eleSummerSub1_2);
        sem1Winter = findViewById(R.id.eleWinterSub1_2);

        sem2Summer = findViewById(R.id.eleSummerSub2_2);
        sem2Winter = findViewById(R.id.eleSummerSub2_2);

        sem3Summer = findViewById(R.id.eleSummerSub3_2);
        sem3Winter = findViewById(R.id.eleSummerSub3_2);

        sem5Summer = findViewById(R.id.eleSummerSub5_2);
        sem5Winter = findViewById(R.id.eleSummerSub5_2);

        sem7Summer = findViewById(R.id.eleSummerSub7_2);
        sem7Winter = findViewById(R.id.eleSummerSub7_2);

        sem1Summer.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/S2025/DI/4320901.pdf"));
        sem1Winter.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/W2024/DI/4320901.pdf"));

        sem2Summer.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/S2025/DI/4300013.pdf"));
        sem2Winter.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/W2024/DI/4300013.pdf"));

        sem3Summer.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/S2025/DI/C4300003.pdf"));
        sem3Winter.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/W2024/DI/C4300003.pdf"));

        sem5Summer.setOnClickListener(view -> openLink("https://gtu.ac.in/uploads/S2025/DI/4300005.pdf"));
        sem5Winter.setOnClickListener(view -> openLink("https://gtu.ac.in/uploads/W2024/DI/4300005.pdf"));

        sem7Summer.setOnClickListener(view -> openLink("https://gtu.ac.in/uploads/S2025/DI/4320002.pdf"));
        sem7Winter.setOnClickListener(view -> openLink("https://gtu.ac.in/uploads/W2024/DI/4320002.pdf"));
    }

    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}