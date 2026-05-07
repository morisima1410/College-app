package com.example.projectexpo.computer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectexpo.R;

public class Compsem6 extends AppCompatActivity {
    Button sub1Summersem6, sub1Wintersem6, sub2Summersem6, sub2Wintersem6,
            sub3Summersem6, sub3Wintersem6, sub4Summersem6, sub4Wintersem6;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_compsem6);
        sub1Summersem6 = findViewById(R.id.btnsubSummer1);
        sub1Wintersem6 = findViewById(R.id.btnsubWinter1);

        sub2Summersem6 = findViewById(R.id.btnsubSummer2);
        sub2Wintersem6 = findViewById(R.id.btnsubWinter2);

        sub3Summersem6 = findViewById(R.id.btnsubSummer3);
        sub3Wintersem6 = findViewById(R.id.btnsubWinter3);

        sub4Summersem6 = findViewById(R.id.btnsubSummer4);
        sub4Wintersem6 = findViewById(R.id.btnsubWinter4);


        sub1Summersem6.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2024/08/summer-2024_cmts.pdf"));
        sub1Wintersem6.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2024/12/cmts-winter-2024.pdf"));

        sub2Summersem6.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2025/06/bis-summer-2025-4360702.pdf"));
        sub2Wintersem6.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2024/12/bis-winter-24.pdf"));

        sub3Summersem6.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2025/06/fiot-summmer-2025-4360703.pdf"));
        sub3Wintersem6.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2024/12/fiot-winter-2024.pdf"));

        sub4Summersem6.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2024/08/summer-2024_cc.pdf"));
        sub4Wintersem6.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2024/12/winter-2024.pdf"));


    }
    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}