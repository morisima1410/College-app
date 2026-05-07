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

public class Civildesign extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_civildesign);
        try {
            // ====== 1. Krunalkumar ======
            ImageView imgKrunal = findViewById(R.id.c1);
            InputStream isKrunal = getAssets().open("images/c1.png");
            Bitmap bitmapKrunal = BitmapFactory.decodeStream(isKrunal);
            imgKrunal.setImageBitmap(bitmapKrunal);
            isKrunal.close();

            // ====== 2. Ureshkumar ======
            ImageView imgUresh = findViewById(R.id.c2);
            InputStream isUresh = getAssets().open("images/c2.jpg");
            Bitmap bitmapUresh = BitmapFactory.decodeStream(isUresh);
            imgUresh.setImageBitmap(bitmapUresh);
            isUresh.close();

            // ====== 3. Pratik ======
            ImageView imgPratik = findViewById(R.id.c3);
            InputStream isPratik = getAssets().open("images/c3.jpg");
            Bitmap bitmapPratik = BitmapFactory.decodeStream(isPratik);
            imgPratik.setImageBitmap(bitmapPratik);
            isPratik.close();

            // ====== 4. Bhailal ======
            ImageView imgBhailal = findViewById(R.id.c4);
            InputStream isBhailal = getAssets().open("images/c4.png");
            Bitmap bitmapBhailal = BitmapFactory.decodeStream(isBhailal);
            imgBhailal.setImageBitmap(bitmapBhailal);
            isBhailal.close();

            // ====== 5. Narendrasinh ======
            ImageView imgNarendrasinh = findViewById(R.id.c5);
            InputStream isNarendrasinh = getAssets().open("images/c5.jpg");
            Bitmap bitmapNarendrasinh = BitmapFactory.decodeStream(isNarendrasinh);
            imgNarendrasinh.setImageBitmap(bitmapNarendrasinh);
            isNarendrasinh.close();

            // ====== 6. Shaily ======
            ImageView imgShaily = findViewById(R.id.c6);
            InputStream isShaily = getAssets().open("images/c6.jpg");
            Bitmap bitmapShaily = BitmapFactory.decodeStream(isShaily);
            imgShaily.setImageBitmap(bitmapShaily);
            isShaily.close();

            // ====== 7. Sanjay ======
            ImageView imgSanjay = findViewById(R.id.c7);
            InputStream isSanjay = getAssets().open("images/c7.jpg");
            Bitmap bitmapSanjay = BitmapFactory.decodeStream(isSanjay);
            imgSanjay.setImageBitmap(bitmapSanjay);
            isSanjay.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}