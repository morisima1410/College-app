package com.example.projectexpo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;

public class Mechanicaldesign extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mechanicaldesign);
        try {

            loadImage(R.id.m1, "m1.jpg");
            loadImage(R.id.m2, "m2.jpg");
            loadImage(R.id.m3, "m3.jpg");
            loadImage(R.id.m4, "m4.jpg");
            loadImage(R.id.m5, "m5.jpg");
            loadImage(R.id.m6, "m6.jpg");
            loadImage(R.id.m7, "m7.jpg");
            loadImage(R.id.m8, "m8.jpg");
            loadImage(R.id.m9, "m9.jpg");
            loadImage(R.id.m10, "m10.jpg");
            loadImage(R.id.m11, "m11.jpg");
            loadImage(R.id.m12, "m12.jpg");
            loadImage(R.id.m13, "m13.jpg");
            loadImage(R.id.m14, "m14.jpg");
            loadImage(R.id.m15, "m15.jpg");
            loadImage(R.id.m16, "m16.jpg");
            loadImage(R.id.m17, "m17.jpg");
            loadImage(R.id.m18, "m18.jpg");
            loadImage(R.id.m19, "m19.jpg");
            loadImage(R.id.m20, "m20.jpg");
            loadImage(R.id.m21, "m21.jpg");
            loadImage(R.id.m22, "m22.jpg");
            loadImage(R.id.m23, "m23.jpg");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadImage(int id, String fileName) throws IOException {

        ImageView img = findViewById(id);
        InputStream is = getAssets().open("images/" + fileName);

        Bitmap bitmap = BitmapFactory.decodeStream(is);
        img.setImageBitmap(bitmap);

        is.close();
    }
}
