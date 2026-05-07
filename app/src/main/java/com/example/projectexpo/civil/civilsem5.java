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

public class civilsem5 extends AppCompatActivity {
    Button sem1Summer, sem1Winter, sem2Summer, sem2Winter,
            sem3Summer, sem3Winter, sem4Summer, sem4Winter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_civilsem5);
        sem1Summer = findViewById(R.id.btndssSummer);
        sem1Winter = findViewById(R.id.btndssWinter);

        sem2Summer = findViewById(R.id.btntechSummer);
        sem2Winter = findViewById(R.id.btntechWinter);

        sem3Summer = findViewById(R.id.btnwsseSummer);
        sem3Winter = findViewById(R.id.btnwsseWinter);

        sem4Summer = findViewById(R.id.btnactSummer);
        sem4Winter = findViewById(R.id.btnactWinter);

        sem1Summer.setOnClickListener(v -> openLink("https://vpmpcivil654.wordpress.com/wp-content/uploads/2018/07/3350601-s-18.pdf"));
        sem1Winter.setOnClickListener(v -> openLink("https://vpmpcivil654.wordpress.com/wp-content/uploads/2018/07/3350601-w-16.pdf"));

        sem2Summer.setOnClickListener(v -> openLink("https://vpmpcivil654.wordpress.com/wp-content/uploads/2018/07/3350602-s-18.pdf"));
        sem2Winter.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/W2018/DI/3350602.pdf"));

        sem3Summer.setOnClickListener(v -> openLink("https://vpmpcivil654.wordpress.com/wp-content/uploads/2018/07/3350603-s-18.pdf"));
        sem3Winter.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/W2018/DI/3350603.pdf"));

        sem4Summer.setOnClickListener(view -> openLink("https://vpmpcivil654.wordpress.com/wp-content/uploads/2018/07/3350605-s-18.pdf"));
        sem4Winter.setOnClickListener(view -> openLink("https://gtu.ac.in/uploads/W2018/DI/3350605.pdf"));
    }
    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}