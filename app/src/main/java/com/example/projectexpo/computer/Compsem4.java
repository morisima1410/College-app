package com.example.projectexpo.computer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectexpo.R;

public class Compsem4 extends AppCompatActivity {
    Button sub1Summersem4, sub1Wintersem4, sub2Summersem4, sub2Wintersem4,
            sub3Summersem4, sub3Wintersem4, sub4Summersem4, sub4Wintersem4,
            sub5Summersem4, sub5Wintersem4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_compsem4);
        sub1Summersem4 = findViewById(R.id.subSummer1_4);
        sub1Wintersem4 = findViewById(R.id.subWinter1_4);

        sub2Summersem4 = findViewById(R.id.subSummer2_4);
        sub2Wintersem4 = findViewById(R.id.subWinter2_4);

        sub3Summersem4 = findViewById(R.id.subSummer3_4);
        sub3Wintersem4 = findViewById(R.id.subWinter3_4);

        sub4Summersem4 = findViewById(R.id.subSummer4_4);
        sub4Wintersem4 = findViewById(R.id.subWinter4_4);

        sub5Summersem4 = findViewById(R.id.subSummer5_4);
        sub5Wintersem4 = findViewById(R.id.subWinter5_4);

        sub1Summersem4.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2025/06/ipdc-summer-2025-4340003.pdf "));
        sub1Wintersem4.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2025/03/winter-2024-4340003.pdf"));

        sub2Summersem4.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2025/06/aoop-summer-2025-4340701.pdf"));
        sub2Wintersem4.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2025/03/winter-2024-4340701.pdf"));

        sub3Summersem4.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2025/06/ise-summer-2025-4340702.pdf"));
        sub3Wintersem4.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2025/03/winter-2024-4340702.pdf"));

        sub4Summersem4.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2025/06/cn-summer-2025-4340703.pdf"));
        sub4Wintersem4.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2025/03/wintter-2024-4340703.pdf"));

        sub5Summersem4.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2025/06/iwd-summer-2025-4340704.pdf"));
        sub5Wintersem4.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2025/03/winter-2024-4340704.pdf"));

    }
    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}