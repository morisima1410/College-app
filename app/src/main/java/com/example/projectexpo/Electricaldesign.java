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

public class Electricaldesign extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_electricaldesign);
        try {
            // ====== 1. Krunalkumar ======
            ImageView imgKrunal = findViewById(R.id.e1);
            InputStream isKrunal = getAssets().open("images/e1.jpg");
            Bitmap bitmapKrunal = BitmapFactory.decodeStream(isKrunal);
            imgKrunal.setImageBitmap(bitmapKrunal);
            isKrunal.close();

            // ====== 2. Ureshkumar ======
            ImageView imgUresh = findViewById(R.id.e2);
            InputStream isUresh = getAssets().open("images/e2.jpg");
            Bitmap bitmapUresh = BitmapFactory.decodeStream(isUresh);
            imgUresh.setImageBitmap(bitmapUresh);
            isUresh.close();

            // ====== 3. Pratik ======
            ImageView imgPratik = findViewById(R.id.e3);
            InputStream isPratik = getAssets().open("images/e3.jpg");
            Bitmap bitmapPratik = BitmapFactory.decodeStream(isPratik);
            imgPratik.setImageBitmap(bitmapPratik);
            isPratik.close();

            // ====== 4. Bhailal ======
            ImageView imgBhailal = findViewById(R.id.e4);
            InputStream isBhailal = getAssets().open("images/e4.jpg");
            Bitmap bitmapBhailal = BitmapFactory.decodeStream(isBhailal);
            imgBhailal.setImageBitmap(bitmapBhailal);
            isBhailal.close();

            // ====== 5. Narendrasinh ======
            ImageView imgNarendrasinh = findViewById(R.id.e5);
            InputStream isNarendrasinh = getAssets().open("images/e5.jpg");
            Bitmap bitmapNarendrasinh = BitmapFactory.decodeStream(isNarendrasinh);
            imgNarendrasinh.setImageBitmap(bitmapNarendrasinh);
            isNarendrasinh.close();

            // ====== 6. Shaily ======
            ImageView imgShaily = findViewById(R.id.e6);
            InputStream isShaily = getAssets().open("images/e6.jpg");
            Bitmap bitmapShaily = BitmapFactory.decodeStream(isShaily);
            imgShaily.setImageBitmap(bitmapShaily);
            isShaily.close();

            // ====== 7. Sanjay ======
            ImageView imgSanjay = findViewById(R.id.e7);
            InputStream isSanjay = getAssets().open("images/e7.jpg");
            Bitmap bitmapSanjay = BitmapFactory.decodeStream(isSanjay);
            imgSanjay.setImageBitmap(bitmapSanjay);
            isSanjay.close();
            // ====== 8 ======
            ImageView img8 = findViewById(R.id.e8);
            InputStream is8 = getAssets().open("images/e8.jpg");
            Bitmap bmp8 = BitmapFactory.decodeStream(is8);
            img8.setImageBitmap(bmp8);
            is8.close();

// ====== 9 ======
            ImageView img9 = findViewById(R.id.e9);
            InputStream is9 = getAssets().open("images/e9.jpg");
            Bitmap bmp9 = BitmapFactory.decodeStream(is9);
            img9.setImageBitmap(bmp9);
            is9.close();

// ====== 10 ======
            ImageView img10 = findViewById(R.id.e10);
            InputStream is10 = getAssets().open("images/e10.jpg");
            Bitmap bmp10 = BitmapFactory.decodeStream(is10);
            img10.setImageBitmap(bmp10);
            is10.close();

// ====== 11 ======
            ImageView img11 = findViewById(R.id.e11);
            InputStream is11 = getAssets().open("images/e11.jpg");
            Bitmap bmp11 = BitmapFactory.decodeStream(is11);
            img11.setImageBitmap(bmp11);
            is11.close();

// ====== 12 ======
            ImageView img12 = findViewById(R.id.e12);
            InputStream is12 = getAssets().open("images/e12.jpg");
            Bitmap bmp12 = BitmapFactory.decodeStream(is12);
            img12.setImageBitmap(bmp12);
            is12.close();

// ====== 13 ======
            ImageView img13 = findViewById(R.id.e13);
            InputStream is13 = getAssets().open("images/e13.jpg");
            Bitmap bmp13 = BitmapFactory.decodeStream(is13);
            img13.setImageBitmap(bmp13);
            is13.close();

// ====== 14 ======
            ImageView img14 = findViewById(R.id.e14);
            InputStream is14 = getAssets().open("images/e14.jpg");
            Bitmap bmp14 = BitmapFactory.decodeStream(is14);
            img14.setImageBitmap(bmp14);
            is14.close();

// ====== 15 ======
            ImageView img15 = findViewById(R.id.e15);
            InputStream is15 = getAssets().open("images/e15.jpg");
            Bitmap bmp15 = BitmapFactory.decodeStream(is15);
            img15.setImageBitmap(bmp15);
            is15.close();

// ====== 16 ======
            ImageView img16 = findViewById(R.id.e16);
            InputStream is16 = getAssets().open("images/e16.jpg");
            Bitmap bmp16 = BitmapFactory.decodeStream(is16);
            img16.setImageBitmap(bmp16);
            is16.close();

// ====== 17 ======
            ImageView img17 = findViewById(R.id.e17);
            InputStream is17 = getAssets().open("images/e17.jpg");
            Bitmap bmp17 = BitmapFactory.decodeStream(is17);
            img17.setImageBitmap(bmp17);
            is17.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
