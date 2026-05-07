package com.example.projectexpo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectexpo.model.ActivityModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;

public class NotesActivity extends AppCompatActivity {
    Button midButton, gtuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_notes);

        midButton = findViewById(R.id.midButton);
        gtuButton = findViewById(R.id.gtuButton);

        // 🔗 MID RESULT LINK
        midButton.setOnClickListener(v -> {
            logUserActivity("Opened MID Result Link");
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.me.gtu.ac.in/student/studentmarkdisplay.aspx"));
            startActivity(intent);
        });

        // 🔗 GTU RESULT LINK
        gtuButton.setOnClickListener(v -> {
            logUserActivity("Opened GTU Result Link");
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.gturesults.in/"));
            startActivity(intent);
        });

        // 🔹 Log opening NotesActivity
        logUserActivity("Opened NotesActivity");
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
