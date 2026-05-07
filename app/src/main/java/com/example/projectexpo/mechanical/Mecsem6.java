package com.example.projectexpo.mechanical;

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

public class Mecsem6 extends AppCompatActivity {
    Button sem1Summer, sem1Winter, sem2Summer, sem2Winter,
            sem3Summer, sem3Winter, sem4Summer, sem4Winter, sem5Summer, sem5Winter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mecsem6);
        sem1Summer = findViewById(R.id.mecSummerSub1_6);
        sem1Winter = findViewById(R.id.mecWinterSub1_6);

        sem2Summer = findViewById(R.id.mecSummerSub2_6);
        sem2Winter = findViewById(R.id.mecSummerSub2_6);

        sem3Summer = findViewById(R.id.mecSummerSub3_6);
        sem3Winter = findViewById(R.id.mecSummerSub3_6);

        sem4Summer = findViewById(R.id.mecSummerSub4_6);
        sem4Winter = findViewById(R.id.mecSummerSub4_6);

        sem5Summer = findViewById(R.id.mecSummerSub5_6);
        sem5Winter = findViewById(R.id.mecSummerSub5_6);

        sem1Summer.setOnClickListener(v -> openLink("https://vpmpme.wordpress.com/wp-content/uploads/2022/01/3361901-summer-2019.pdf"));
        sem1Winter.setOnClickListener(v -> openLink("https://vpmpme.wordpress.com/wp-content/uploads/2022/01/3361901-winter-2019.pdf"));

        sem2Summer.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/S2023/DI/3361902.pdf"));
        sem2Winter.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/W2023/DI/3361902.pdf"));

        sem3Summer.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/S2023/DI/3361903.pdf"));
        sem3Winter.setOnClickListener(v -> openLink("https://gtu.ac.in/uploads/W2023/DI/3361903.pdf"));

        sem4Summer.setOnClickListener(view -> openLink("https://vpmpme.wordpress.com/wp-content/uploads/2022/01/3361904-10-08-2021-summer-2021.pdf"));
        sem4Winter.setOnClickListener(view -> openLink("https://vpmpme.wordpress.com/wp-content/uploads/2022/01/3361904-10-12-2021-winter-2021.pdf"));

        sem5Summer.setOnClickListener(view -> openLink("https://vpmpme.wordpress.com/wp-content/uploads/2023/04/3361905-diploma-summer-2022.pdf"));
        sem5Winter.setOnClickListener(view -> openLink("https://vpmpme.wordpress.com/wp-content/uploads/2023/03/3361905-diploma-winter-2022.pdf"));
    }

    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

}


