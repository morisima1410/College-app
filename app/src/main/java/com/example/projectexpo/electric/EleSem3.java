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

public class EleSem3 extends AppCompatActivity {
    Button sem1Summer, sem1Winter, sem2Summer, sem2Winter,
            sem3Summer, sem3Winter, sem4Summer, sem4Winter, sem5Summer, sem5Winter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ele_sem3);
        sem1Summer = findViewById(R.id.eleSummerSub1_3);
        sem1Winter = findViewById(R.id.eleWinterSub1_3);

        sem2Summer = findViewById(R.id.eleSummerSub2_3);
        sem2Winter = findViewById(R.id.eleSummerSub2_3);

        sem3Summer = findViewById(R.id.eleSummerSub3_3);
        sem3Winter = findViewById(R.id.eleSummerSub3_3);

        sem4Summer = findViewById(R.id.eleSummerSub4_3);
        sem4Winter = findViewById(R.id.eleSummerSub4_3);



        sem1Summer.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/S2025/DI/4330901.pdf"));
        sem1Winter.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/W2024/DI/4330901.pdf"));

        sem2Summer.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/S2025/DI/4330902.pdf"));
        sem2Winter.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/W2024/DI/4330902.pdf"));

        sem3Summer.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/S2025/DI/4330903.pdf"));
        sem3Winter.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/W2024/DI/4330903.pdf"));

        sem4Summer.setOnClickListener(view -> openLink("https://gtu.ac.in/uploads/S2025/DI/4330904.pdf"));
        sem4Winter.setOnClickListener(view -> openLink("https://gtu.ac.in/uploads/W2024/DI/4330904.pdf"));

    }
    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

}