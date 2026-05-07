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

public class civilsem6 extends AppCompatActivity {
    Button sem1Summer, sem1Winter, sem2Summer, sem2Winter,
            sem3Summer, sem3Winter, sem4Summer, sem4Winter, sem5Summer, sem5Winter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_civilsem6);
        sem1Summer = findViewById(R.id.btndcsSummer);
        sem1Winter = findViewById(R.id.btndcsWinter);

        sem2Summer = findViewById(R.id.btncqcmSummer);
        sem2Winter = findViewById(R.id.btncqcmWinter);

        sem3Summer = findViewById(R.id.btncpmSummer);
        sem3Winter = findViewById(R.id.btncpmWinter);

        sem4Summer = findViewById(R.id.btnbs1Summer);
        sem4Winter = findViewById(R.id.btnbs1Winter);

        sem5Summer = findViewById(R.id.btnmrsSummer);
        sem5Winter = findViewById(R.id.btnmrsWinter);

        sem1Summer.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/S2018/DI/3360601.pdf"));
        sem1Winter.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/W2018/DI/3360601.pdf"));

        sem2Summer.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/S2018/DI/3360602.pdf"));
        sem2Winter.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/W2018/DI/3360602.pdf"));

        sem3Summer.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/S2018/DI/3360603.pdf"));
        sem3Winter.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/W2018/DI/3360603.pdf"));

        sem4Summer.setOnClickListener(view -> openLink("https://gtu.ac.in/uploads/S2018/DI/3360604.pdf"));
        sem4Winter.setOnClickListener(view -> openLink("https://gtu.ac.in/uploads/W2018/DI/3360604.pdf"));

        sem5Summer.setOnClickListener(view -> openLink("https://gtu.ac.in/uploads/S2018/DI/3360605.pdf"));
        sem5Winter.setOnClickListener(view -> openLink("https://gtu.ac.in/uploads/W2018/DI/3360605.pdf"));
    }

    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}