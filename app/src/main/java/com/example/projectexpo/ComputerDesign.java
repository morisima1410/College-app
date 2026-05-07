package com.example.projectexpo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;

public class ComputerDesign extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_computer_design);
        try {
            // ====== 1. Krunalkumar ======
            ImageView imgKrunal = findViewById(R.id.img_krunalkumar);
            InputStream isKrunal = getAssets().open("images/krunalkumar.png");
            Bitmap bitmapKrunal = BitmapFactory.decodeStream(isKrunal);
            imgKrunal.setImageBitmap(bitmapKrunal);
            isKrunal.close();

            // ====== 2. Ureshkumar ======
            ImageView imgUresh = findViewById(R.id.img_ureshkumar);
            InputStream isUresh = getAssets().open("images/ureshkumar.jpg");
            Bitmap bitmapUresh = BitmapFactory.decodeStream(isUresh);
            imgUresh.setImageBitmap(bitmapUresh);
            isUresh.close();

            // ====== 3. Pratik ======
            ImageView imgPratik = findViewById(R.id.img_pratik);
            InputStream isPratik = getAssets().open("images/parrik.jpg");
            Bitmap bitmapPratik = BitmapFactory.decodeStream(isPratik);
            imgPratik.setImageBitmap(bitmapPratik);
            isPratik.close();

            // ====== 4. Bhailal ======
            ImageView imgBhailal = findViewById(R.id.img_bhailal);
            InputStream isBhailal = getAssets().open("images/bhailal.jpg");
            Bitmap bitmapBhailal = BitmapFactory.decodeStream(isBhailal);
            imgBhailal.setImageBitmap(bitmapBhailal);
            isBhailal.close();

            // ====== 5. Narendrasinh ======
            ImageView imgNarendrasinh = findViewById(R.id.img_narendrasinh);
            InputStream isNarendrasinh = getAssets().open("images/narendrasinh.jpg");
            Bitmap bitmapNarendrasinh = BitmapFactory.decodeStream(isNarendrasinh);
            imgNarendrasinh.setImageBitmap(bitmapNarendrasinh);
            isNarendrasinh.close();

            // ====== 6. Shaily ======
            ImageView imgShaily = findViewById(R.id.img_shaily);
            InputStream isShaily = getAssets().open("images/shaily.jpg");
            Bitmap bitmapShaily = BitmapFactory.decodeStream(isShaily);
            imgShaily.setImageBitmap(bitmapShaily);
            isShaily.close();

            // ====== 7. Sanjay ======
            ImageView imgSanjay = findViewById(R.id.img_sanjay);
            InputStream isSanjay = getAssets().open("images/sanjay.jpg");
            Bitmap bitmapSanjay = BitmapFactory.decodeStream(isSanjay);
            imgSanjay.setImageBitmap(bitmapSanjay);
            isSanjay.close();

            // ====== 8. Shaktisinh ======
            ImageView imgShakti = findViewById(R.id.img_shaktisinh);
            InputStream isShakti = getAssets().open("images/shakti.jpg");
            Bitmap bitmapShakti = BitmapFactory.decodeStream(isShakti);
            imgShakti.setImageBitmap(bitmapShakti);
            isShakti.close();

            // ====== 9. Niketa ======
            ImageView imgNiketa = findViewById(R.id.img_niketa);
            InputStream isNiketa = getAssets().open("images/niketa.jpg");
            Bitmap bitmapNiketa = BitmapFactory.decodeStream(isNiketa);
            imgNiketa.setImageBitmap(bitmapNiketa);
            isNiketa.close();

            // ====== 10. Binal ======
            ImageView imgBinal = findViewById(R.id.img_binal);
            InputStream isBinal = getAssets().open("images/binal.jpg");
            Bitmap bitmapBinal = BitmapFactory.decodeStream(isBinal);
            imgBinal.setImageBitmap(bitmapBinal);
            isBinal.close();

            // ====== 11. Vishal ======
            ImageView imgVishal = findViewById(R.id.img_vishal);
            InputStream isVishal = getAssets().open("images/vishal.jpg");
            Bitmap bitmapVishal = BitmapFactory.decodeStream(isVishal);
            imgVishal.setImageBitmap(bitmapVishal);
            isVishal.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
