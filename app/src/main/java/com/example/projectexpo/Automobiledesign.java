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

public class Automobiledesign extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_automobiledesign);
        try {
            // ====== 1. Krunalkumar ======
            ImageView imgKrunal = findViewById(R.id.a1);
            InputStream isKrunal = getAssets().open("images/a1.jpg");
            Bitmap bitmapKrunal = BitmapFactory.decodeStream(isKrunal);
            imgKrunal.setImageBitmap(bitmapKrunal);
            isKrunal.close();

            // ====== 2. Ureshkumar ======
            ImageView imgUresh = findViewById(R.id.a2);
            InputStream isUresh = getAssets().open("images/a2.jpg");
            Bitmap bitmapUresh = BitmapFactory.decodeStream(isUresh);
            imgUresh.setImageBitmap(bitmapUresh);
            isUresh.close();

            // ====== 3. Pratik ======
            ImageView imgPratik = findViewById(R.id.a3);
            InputStream isPratik = getAssets().open("images/a3.jpg");
            Bitmap bitmapPratik = BitmapFactory.decodeStream(isPratik);
            imgPratik.setImageBitmap(bitmapPratik);
            isPratik.close();

            // ====== 4. Bhailal ======
            ImageView imgBhailal = findViewById(R.id.a4);
            InputStream isBhailal = getAssets().open("images/a4.jpg");
            Bitmap bitmapBhailal = BitmapFactory.decodeStream(isBhailal);
            imgBhailal.setImageBitmap(bitmapBhailal);
            isBhailal.close();

            // ====== 5. Narendrasinh ======
            ImageView imgNarendrasinh = findViewById(R.id.a5);
            InputStream isNarendrasinh = getAssets().open("images/a5.jpg");
            Bitmap bitmapNarendrasinh = BitmapFactory.decodeStream(isNarendrasinh);
            imgNarendrasinh.setImageBitmap(bitmapNarendrasinh);
            isNarendrasinh.close();

            // ====== 6. Shaily ======
            ImageView imgShaily = findViewById(R.id.a6);
            InputStream isShaily = getAssets().open("images/a6.jpg");
            Bitmap bitmapShaily = BitmapFactory.decodeStream(isShaily);
            imgShaily.setImageBitmap(bitmapShaily);
            isShaily.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
