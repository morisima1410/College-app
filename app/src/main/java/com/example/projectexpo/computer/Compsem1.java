package com.example.projectexpo.computer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectexpo.R;

public class Compsem1 extends AppCompatActivity {
    Button sub1Summer, sub1Winter, sub2Summer, sub2Winter,
            sub3Summer, sub3Winter, sub4Summer, sub4Winter,
            sub5Summer, sub5Winter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_compsem1);
        sub1Summer = findViewById(R.id.sub1Summer);
        sub1Winter = findViewById(R.id.sub1Winter);

        sub2Summer = findViewById(R.id.sub2Summer);
        sub2Winter = findViewById(R.id.sub2Winter);

        sub3Summer = findViewById(R.id.sub3Summer);
        sub3Winter = findViewById(R.id.sub3Winter);

        sub4Summer = findViewById(R.id.sub4Summer);
        sub4Winter = findViewById(R.id.sub4Winter);

        sub5Summer = findViewById(R.id.sub5Summer);
        sub5Winter = findViewById(R.id.sub5Winter);


        sub1Summer.setOnClickListener(v -> openLink("https://share.google/p6Td3I3q5NJ1W3mBF"));
        sub1Winter.setOnClickListener(v -> openLink("https://share.google/irW5cu4EMjpPlzbqi"));

        sub2Summer.setOnClickListener(v -> openLink("https://share.google/hZN8Oc6FqkRyvT4gP"));
        sub2Winter.setOnClickListener(v -> openLink("https://share.google/GQskuNxQ1xswJNvv2"));

        sub4Summer.setOnClickListener(v -> openLink("https://share.google/LMcVPDUEkm3zmVvHp"));
        sub4Winter.setOnClickListener(v -> openLink("https://share.google/rabbX5dGZowbc07Br"));

        sub3Summer.setOnClickListener(v -> openLink("https://share.google/hwAY4dlZdI8JH9S3r"));
        sub3Winter.setOnClickListener(v -> openLink("https://share.google/8oiLKC1USqXwexqwo"));

        sub5Summer.setOnClickListener(v -> openLink("https://share.google/BT8MMDNLRl9HKLrRZ"));
        sub5Winter.setOnClickListener(v -> openLink("https://share.google/KW4PCAWkMNajbAxjr"));
    }

    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}