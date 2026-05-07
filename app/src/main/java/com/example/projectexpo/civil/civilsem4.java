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

public class civilsem4 extends AppCompatActivity {
    Button sem1Summer, sem1Winter, sem2Summer, sem2Winter,
            sem3Summer, sem3Winter, sem4Summer, sem4Winter, sem5Summer, sem5Winter,sem6Summer,sem6Winter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_civilsem4);
        sem1Summer = findViewById(R.id.btnsm1Summer);
        sem1Winter = findViewById(R.id.btnsm1Winter);

        sem2Summer = findViewById(R.id.btnsurSummer);
        sem2Winter = findViewById(R.id.btnsurWinter);

        sem3Summer = findViewById(R.id.btnbteSummer);
        sem3Winter = findViewById(R.id.btnbteWinter);

        sem4Summer = findViewById(R.id.btnwrmSummer);
        sem4Winter = findViewById(R.id.btnwrmWinter);

        sem5Summer = findViewById(R.id.btnmecSummer);
        sem5Winter = findViewById(R.id.btnmecWinter);


        sem1Summer.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/S2018/DI/3340601.pdf"));
        sem1Winter.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/W2018/DI/3340601.pdf"));

        sem2Summer.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/S2018/DI/3340602.pdf"));
        sem2Winter.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/W2018/DI/3340602.pdf"));

        sem3Summer.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/S2018/DI/3340603.pdf"));
        sem3Winter.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/W2018/DI/3340603.pdf"));

        sem4Summer.setOnClickListener(view -> openLink("https://gtu.ac.in/uploads/S2019/DI/3340604.pdf"));
        sem4Winter.setOnClickListener(view -> openLink("https://gtu.ac.in/uploads/W2018/DI/3340603.pdf"));

        sem5Summer.setOnClickListener(view -> openLink("https://gtu.ac.in/uploads/S2019/DI/3340605.pdf"));
        sem5Winter.setOnClickListener(view -> openLink("https://gtu.ac.in/uploads/W2019/DI/3340605.pdf"));


    }
    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}