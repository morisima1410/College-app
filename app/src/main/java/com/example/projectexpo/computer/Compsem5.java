package com.example.projectexpo.computer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectexpo.R;

public class Compsem5 extends AppCompatActivity {
    Button sub1Summersem5, sub1Wintersem5, sub2Summersem5, sub2Wintersem5,
            sub3Summersem5, sub3Wintersem5, sub4Summersem5, sub4Wintersem5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_compsem5);
        sub1Summersem5 = findViewById(R.id.btsubSummer1);
        sub1Wintersem5 = findViewById(R.id.btsubWinter1);

        sub2Summersem5 = findViewById(R.id.btsubSummer2);
        sub2Wintersem5 = findViewById(R.id.btsubWinter2);

        sub3Summersem5 = findViewById(R.id.btsubSummer3);
        sub3Wintersem5 = findViewById(R.id.btsubWinter3);

        sub4Summersem5 = findViewById(R.id.btsubSummer4);
        sub4Wintersem5 = findViewById(R.id.btsubWinter4);

        sub1Summersem5.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2025/06/esu-summer-2025-4300021.pdf"));
        sub1Wintersem5.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2025/06/esu-winter-2024-4300021.pdf"));

        sub2Summersem5.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2025/06/coa-summer-2025-4350701.pdf"));
        sub2Wintersem5.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2025/06/coa-winter-2024-4350701.pdf"));

        sub3Summersem5.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2025/06/iml-summer-2025-4350702.pdf"));
        sub3Wintersem5.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2025/06/iml-winter-2024-4350702.pdf"));

        sub4Summersem5.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2025/06/acn-summer-2025-4350706.pdf"));
        sub4Wintersem5.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2025/06/acn-winter-2024-4350706.pdf"));


    }
    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}