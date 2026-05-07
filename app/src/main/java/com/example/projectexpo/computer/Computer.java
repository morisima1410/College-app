package com.example.projectexpo.computer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import com.example.projectexpo.civil.civilsem1;
import com.example.projectexpo.civil.civilsem2;
import com.example.projectexpo.civil.civilsem3;
import com.example.projectexpo.civil.civilsem4;
import com.example.projectexpo.civil.civilsem5;
import com.example.projectexpo.civil.civilsem6;
import com.example.projectexpo.R;
import com.example.projectexpo.electric.EleSem1;
import com.example.projectexpo.electric.EleSem2;
import com.example.projectexpo.electric.EleSem3;
import com.example.projectexpo.electric.EleSem4;
import com.example.projectexpo.electric.EleSem5;
import com.example.projectexpo.electric.EleSem6;
import com.example.projectexpo.mechanical.Mecsem1;
import com.example.projectexpo.mechanical.Mecsem2;
import com.example.projectexpo.mechanical.Mecsem3;
import com.example.projectexpo.mechanical.Mecsem4;
import com.example.projectexpo.mechanical.Mecsem5;

public class Computer extends AppCompatActivity {

    LinearLayout c1, c2, c3, c4, c5, c6;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_computer);

        c1 = findViewById(R.id.btcomputer1);
        c2 = findViewById(R.id.btcomputer2);
        c3 = findViewById(R.id.btcomputer3);
        c4 = findViewById(R.id.btcomputer4);
        c5 = findViewById(R.id.btcomputer5);
        c6 = findViewById(R.id.btcomputer6);

        String dept = getIntent().getStringExtra("dept");

        if (dept != null) {
            switch (dept) {
                case "computer":
                    Toast.makeText(this, "Computer Department Selected", Toast.LENGTH_SHORT).show();
                    // Subject buttons for Computer
                    c1.setOnClickListener(v -> startActivity(new Intent(this, Compsem1.class)));
                    c2.setOnClickListener(v -> startActivity(new Intent(this, Compsem2.class)));
                    c3.setOnClickListener(v -> startActivity(new Intent(this, Compsem3.class)));
                    c4.setOnClickListener(v -> startActivity(new Intent(this, Compsem4.class)));
                    c5.setOnClickListener(v -> startActivity(new Intent(this, Compsem5.class)));
                    c6.setOnClickListener(v -> startActivity(new Intent(this, Compsem6.class)));
                    break;

                case "civil":
                    Toast.makeText(this, "Civil Department Selected", Toast.LENGTH_SHORT).show();
                    c1.setOnClickListener(v -> startActivity(new Intent(this, civilsem1.class)));
                    c2.setOnClickListener(v -> startActivity(new Intent(this, civilsem2.class)));
                    c3.setOnClickListener(v -> startActivity(new Intent(this, civilsem3.class)));
                    c4.setOnClickListener(v -> startActivity(new Intent(this, civilsem4.class)));
                    c5.setOnClickListener(v -> startActivity(new Intent(this, civilsem5.class)));
                    c6.setOnClickListener(v -> startActivity(new Intent(this, civilsem6.class)));
                    break;

                case "mechanical":
                    Toast.makeText(this, "Mechanical Department Selected", Toast.LENGTH_SHORT).show();
                    c1.setOnClickListener(v -> startActivity(new Intent(this, Mecsem1.class)));
                    c2.setOnClickListener(v -> startActivity(new Intent(this, Mecsem2.class)));
                    c3.setOnClickListener(v -> startActivity(new Intent(this, Mecsem3.class)));
                    c4.setOnClickListener(v -> startActivity(new Intent(this, Mecsem4.class)));
                    c5.setOnClickListener(v -> startActivity(new Intent(this, Mecsem5.class)));
                    c6.setOnClickListener(v -> startActivity(new Intent(this, Mecsem5.class)));
                    break;

                case "automobile":
                    Toast.makeText(this, "Automobile Department Selected", Toast.LENGTH_SHORT).show();
                    c1.setOnClickListener(v -> startActivity(new Intent(this, Compsem1.class)));
                    c2.setOnClickListener(v -> startActivity(new Intent(this, Compsem2.class)));
                    c3.setOnClickListener(v -> startActivity(new Intent(this, Compsem3.class)));
                    c4.setOnClickListener(v -> startActivity(new Intent(this, Compsem4.class)));
                    c5.setOnClickListener(v -> startActivity(new Intent(this, Compsem5.class)));
                    c6.setOnClickListener(v -> startActivity(new Intent(this, Compsem6.class)));
                    break;

                case "electrical":
                    Toast.makeText(this, "Electrical Department Selected", Toast.LENGTH_SHORT).show();
                    c1.setOnClickListener(v -> startActivity(new Intent(this, EleSem1.class)));
                    c2.setOnClickListener(v -> startActivity(new Intent(this, EleSem2.class)));
                    c3.setOnClickListener(v -> startActivity(new Intent(this, EleSem3.class)));
                    c4.setOnClickListener(v -> startActivity(new Intent(this, EleSem4.class)));
                    c5.setOnClickListener(v -> startActivity(new Intent(this, EleSem5.class)));
                    c6.setOnClickListener(v -> startActivity(new Intent(this, EleSem6.class)));
                    break;

                default:
                    Toast.makeText(this, "Unknown Department", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
