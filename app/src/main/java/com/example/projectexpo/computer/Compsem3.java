package com.example.projectexpo.computer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectexpo.R;

public class Compsem3 extends AppCompatActivity {
    Button sub1Summersem3, sub1Wintersem3, sub2Summersem3, sub2Wintersem3,
            sub3Summersem3, sub3Wintersem3, sub4Summersem3, sub4Wintersem3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_compsem3);
        sub1Summersem3 = findViewById(R.id.subSummer1_1);
        sub1Wintersem3 = findViewById(R.id.subWinter1_1);

        sub2Summersem3 = findViewById(R.id.subSummer2_2);
        sub2Wintersem3 = findViewById(R.id.subWinter2_2);

        sub3Summersem3 = findViewById(R.id.subSummer3_3);
        sub3Wintersem3 = findViewById(R.id.subWinter3_3);

        sub4Summersem3 = findViewById(R.id.subSummer4_4);
        sub4Wintersem3 = findViewById(R.id.subWinter4_4);
        sub1Summersem3.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2023/08/rdbms_summer-2023.pdf"));
        sub1Wintersem3.setOnClickListener(v -> openLink(""));

        sub2Summersem3.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2023/08/winter-2022.pdf"));
        sub2Wintersem3.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2023/08/winter-2022.pdf"));

        sub3Summersem3.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2023/08/bos_summer-2023.pdf"));
        sub3Wintersem3.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2023/08/bos_winter-2022.pdf"));

        sub4Summersem3.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2023/08/dsa_summer-2023.pdf"));
        sub4Wintersem3.setOnClickListener(v -> openLink("https://vpmpce.wordpress.com/wp-content/uploads/2023/08/dsa_winter-2022.pdf"));


    }

    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}