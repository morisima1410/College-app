package com.example.projectexpo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectexpo.model.ActivityModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FacultyActivity extends AppCompatActivity {

    LinearLayout comp, civ, mec, auto, ele, cddm, gen;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_faculty);

        comp = findViewById(R.id.btcomputer);
        civ = findViewById(R.id.btcivil);
        mec = findViewById(R.id.btmechanical);
        auto = findViewById(R.id.btautomobile);
        ele = findViewById(R.id.btelectrical);
        cddm = findViewById(R.id.btcddm);
        gen = findViewById(R.id.btgeneral);

        // 🔹 Log opening FacultyActivity
        logUserActivity("Opened FacultyActivity");

        comp.setOnClickListener(v -> {
            logUserActivity("Opened Computer Design");
            startActivity(new Intent(FacultyActivity.this, ComputerDesign.class));
        });

        civ.setOnClickListener(v -> {
            logUserActivity("Opened Civil Design");
            startActivity(new Intent(FacultyActivity.this, Civildesign.class));
        });

        mec.setOnClickListener(v -> {
            logUserActivity("Opened Mechanical Design");
            startActivity(new Intent(FacultyActivity.this, Mechanicaldesign.class));
        });

        auto.setOnClickListener(v -> {
            logUserActivity("Opened Automobile Design");
            startActivity(new Intent(FacultyActivity.this, Automobiledesign.class));
        });

        ele.setOnClickListener(v -> {
            logUserActivity("Opened Electrical Design");
            startActivity(new Intent(FacultyActivity.this, Electricaldesign.class));
        });

        cddm.setOnClickListener(v -> {
            logUserActivity("Opened CDDM Design");
            startActivity(new Intent(FacultyActivity.this, CDDMdesign.class));
        });

        gen.setOnClickListener(v -> {
            logUserActivity("Opened General Design");
            startActivity(new Intent(FacultyActivity.this, Generaldesign.class));
        });
    }

    private void logUserActivity(String action) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String uid = user.getUid();
            String name = user.getDisplayName() != null ? user.getDisplayName() : "Unknown";
            long time = System.currentTimeMillis();

            ActivityModel model = new ActivityModel(uid, name, action, time);

            DatabaseReference ref = FirebaseDatabase.getInstance().getReference("ActivityLog").child(uid);
            ref.push().setValue(model);
        }
    }
}
