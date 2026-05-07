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

public class CDDMdesign extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cddmdesign);
        try {

            loadImage(R.id.cd1, "cd1.jpg");
            loadImage(R.id.cd2, "cd2.jpg");
            loadImage(R.id.cd3, "cd3.jpg");
            loadImage(R.id.cd4, "cd4.jpg");
            loadImage(R.id.cd5, "cd5.jpg");

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
