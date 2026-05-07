package com.example.projectexpo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.io.InputStream;

public class Generaldesign extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_generaldesign);
        try {
            // ====== 1. Krunalkumar ======
            ImageView imgKrunal = findViewById(R.id.g1);
            InputStream isKrunal = getAssets().open("images/g1.jpg");
            Bitmap bitmapKrunal = BitmapFactory.decodeStream(isKrunal);
            imgKrunal.setImageBitmap(bitmapKrunal);
            isKrunal.close();

            // ====== 2. Ureshkumar ======
            ImageView imgUresh = findViewById(R.id.g2);
            InputStream isUresh = getAssets().open("images/g2.jpg");
            Bitmap bitmapUresh = BitmapFactory.decodeStream(isUresh);
            imgUresh.setImageBitmap(bitmapUresh);
            isUresh.close();

            // ====== 3. Pratik ======
            ImageView imgPratik = findViewById(R.id.g3);
            InputStream isPratik = getAssets().open("images/g3.jpg");
            Bitmap bitmapPratik = BitmapFactory.decodeStream(isPratik);
            imgPratik.setImageBitmap(bitmapPratik);
            isPratik.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
