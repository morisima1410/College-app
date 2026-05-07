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

public class civilsem3 extends AppCompatActivity {
    Button sem1Summer, sem1Winter, sem2Summer, sem2Winter,
            sem3Summer, sem3Winter, sem4Summer, sem4Winter, sem5Summer, sem5Winter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_civilsem3);

        sem1Summer = findViewById(R.id.btnmatSummer);
        sem1Winter = findViewById(R.id.btnmatWinter);

        sem2Summer = findViewById(R.id.btntecSummer);
        sem2Winter = findViewById(R.id.btntecWinter);

        sem3Summer = findViewById(R.id.btnhydSummer);
        sem3Winter = findViewById(R.id.btnhydWinter);

        sem4Summer = findViewById(R.id.btnsmSummer);
        sem4Winter = findViewById(R.id.btnsmWinter);

        sem5Summer = findViewById(R.id.btnsuSummer);
        sem5Winter = findViewById(R.id.btnsuWinter);

        sem1Summer.setOnClickListener(v -> openLink("https://vpmpcivil654.wordpress.com/wp-content/uploads/2018/07/3330601-s-18.pdf"));
        sem1Winter.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/W2018/DI/3330601.pdf"));

        sem2Summer.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/W2018/DI/3330602.pdf"));
        sem2Winter.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/S2018/DI/3330602.pdf"));

        sem3Summer.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/S2018/DI/3330603.pdf"));
        sem3Winter.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/W2018/DI/3330603.pdf"));

        sem4Summer.setOnClickListener(view -> openLink("https://gtu.ac.in/uploads/S2018/DI/3330604.pdf"));
        sem4Winter.setOnClickListener(view -> openLink("https://gtu.ac.in/uploads/W2018/DI/3330604.pdf"));

        sem5Summer.setOnClickListener(view -> openLink("https://gtu.ac.in/uploads/S2018/DI/3330605.pdf"));
        sem5Winter.setOnClickListener(view -> openLink("https://gtu.ac.in/uploads/W2018/DI/3330605.pdf"));

    }
    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}