package com.example.projectexpo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectexpo.computer.Computer;
import com.example.projectexpo.model.ActivityModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class QuestionpaperActivity extends AppCompatActivity {
    LinearLayout comp, civ, mec, auto, ele, cddm, gen;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_questionpaper);

        comp = findViewById(R.id.btcomputer);
        civ = findViewById(R.id.btcivil);
        mec = findViewById(R.id.btmechanical);
        auto = findViewById(R.id.btautomobile);
        ele = findViewById(R.id.btelectrical);
        cddm = findViewById(R.id.btcddm);
        gen = findViewById(R.id.btgeneral);

        // Fetch current user info
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference("Users");

        // Click listeners with activity log
        comp.setOnClickListener(v -> openDept("computer", uid));
        civ.setOnClickListener(v -> openDept("civil", uid));
        mec.setOnClickListener(v -> openDept("mechanical", uid));
        auto.setOnClickListener(v -> openDept("automobile", uid));
        ele.setOnClickListener(v -> openDept("electrical", uid));
        cddm.setOnClickListener(v -> openDept("cddm", uid));
        gen.setOnClickListener(v -> openDept("general", uid));
    }

    private void openDept(String dept, String uid) {
        // Open activity
        Intent intent = new Intent(QuestionpaperActivity.this, Computer.class);
        intent.putExtra("dept", dept);
        startActivity(intent);

        // Log user activity
        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference("Users").child(uid);
        usersRef.get().addOnSuccessListener(snapshot -> {
            String name = snapshot.child("name").getValue(String.class);

            DatabaseReference activityRef = FirebaseDatabase.getInstance().getReference("ActivityLog");
            long time = System.currentTimeMillis();
            ActivityModel activity = new ActivityModel(uid, name, "Opened " + dept + " Question Papers", time);
            activityRef.child(uid).child(String.valueOf(time)).setValue(activity)
                    .addOnSuccessListener(aVoid -> {
                        // Optional: Toast for debug
                        // Toast.makeText(this, "Activity logged!", Toast.LENGTH_SHORT).show();
                    })
                    .addOnFailureListener(e -> Toast.makeText(this, "Failed to log activity: " + e.getMessage(), Toast.LENGTH_SHORT).show());
        });
    }
}
