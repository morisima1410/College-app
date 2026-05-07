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

public class Mecsem5 extends AppCompatActivity {
    Button sem1Summer, sem1Winter, sem2Summer, sem2Winter,
            sem3Summer, sem3Winter, sem4Summer, sem4Winter, sem5Summer, sem5Winter,sem6Summer,sem6Winter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mecsem5);
        sem1Summer = findViewById(R.id.mecSummerSub1_5);
        sem1Winter = findViewById(R.id.mecWinterSub1_5);

        sem2Summer = findViewById(R.id.mecSummerSub2_5);
        sem2Winter = findViewById(R.id.mecSummerSub2_5);

        sem3Summer = findViewById(R.id.mecSummerSub3_5);
        sem3Winter = findViewById(R.id.mecSummerSub3_5);

        sem4Summer = findViewById(R.id.mecSummerSub4_5);
        sem4Winter = findViewById(R.id.mecSummerSub4_5);

        sem5Summer = findViewById(R.id.mecSummerSub5_5);
        sem5Winter = findViewById(R.id.mecSummerSub5_5);

        sem6Summer = findViewById(R.id.mecSummerSub5_6);
        sem6Winter = findViewById(R.id.mecSummerSub5_6);


        sem1Summer.setOnClickListener(v -> openLink("https://vpmpme.wordpress.com/wp-content/uploads/2020/08/sum19-3351901.pdf"));
        sem1Winter.setOnClickListener(v -> openLink("https://vpmpme.wordpress.com/wp-content/uploads/2020/08/win19-3351901.pdf"));

        sem2Summer.setOnClickListener(v -> openLink("https://vpmpme.wordpress.com/wp-content/uploads/2020/08/sum-19-3351902.pdf"));
        sem2Winter.setOnClickListener(v -> openLink("https://vpmpme.wordpress.com/wp-content/uploads/2020/08/win-19-3351902.pdf"));

        sem3Summer.setOnClickListener(v -> openLink("https://vpmpme.wordpress.com/wp-content/uploads/2020/08/sum-2017-3351903.pdf"));
        sem3Winter.setOnClickListener(v -> openLink("https://vpmpme.wordpress.com/wp-content/uploads/2020/08/w2019-3351903.pdf"));

        sem4Summer.setOnClickListener(view -> openLink("https://vpmpme.wordpress.com/wp-content/uploads/2018/07/3may2018_3351904.pdf"));
        sem4Winter.setOnClickListener(view -> openLink("https://vpmpme.wordpress.com/wp-content/uploads/2018/07/8nov2017_3351904.pdf"));

        sem5Summer.setOnClickListener(view -> openLink("https://www.gtu.ac.in/uploads/S2020/DI/3351905.pdf"));
        sem5Winter.setOnClickListener(view -> openLink("https://www.gtu.ac.in/uploads/W2020/DI/3351905.pdf"));

        sem6Summer.setOnClickListener(view -> openLink("https://vpmpme.wordpress.com/wp-content/uploads/2018/06/3351906-summer-2018.pdf"));
        sem6Winter.setOnClickListener(view -> openLink("https://vpmpme.wordpress.com/wp-content/uploads/2020/08/win19-3351904.pdf"));

    }

    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

}

