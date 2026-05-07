package com.example.projectexpo.electric;

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

public class EleSem4 extends AppCompatActivity {
    Button sem1Summer, sem1Winter, sem2Summer, sem2Winter,
            sem3Summer, sem3Winter, sem4Summer, sem4Winter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ele_sem4);
        sem1Summer = findViewById(R.id.eleSummerSub1_4);
        sem1Winter = findViewById(R.id.eleWinterSub1_4);

        sem2Summer = findViewById(R.id.eleSummerSub2_4);
        sem2Winter = findViewById(R.id.eleSummerSub2_4);

        sem3Summer = findViewById(R.id.eleSummerSub3_4);
        sem3Winter = findViewById(R.id.eleSummerSub3_4);

        sem4Summer = findViewById(R.id.eleSummerSub4_4);
        sem4Winter = findViewById(R.id.eleSummerSub4_4);

        sem1Summer.setOnClickListener(v -> openLink(""));
        sem1Winter.setOnClickListener(v -> openLink(""));

        sem2Summer.setOnClickListener(v -> openLink(""));
        sem2Winter.setOnClickListener(v -> openLink(""));

        sem3Summer.setOnClickListener(v -> openLink(""));
        sem3Winter.setOnClickListener(v -> openLink(""));

        sem4Summer.setOnClickListener(view -> openLink(""));
        sem4Winter.setOnClickListener(view -> openLink(""));
    }
    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}