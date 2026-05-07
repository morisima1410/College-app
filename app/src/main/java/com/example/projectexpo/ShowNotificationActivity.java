package com.example.projectexpo;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectexpo.Adapter.NotificationAdapter;
import com.example.projectexpo.model.ActivityModel;
import com.example.projectexpo.model.NotificationModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ShowNotificationActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    NotificationAdapter adapter;
    ArrayList<NotificationModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_notification);

        recyclerView = findViewById(R.id.recyclerViewNotification);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        adapter = new NotificationAdapter(this, list);
        recyclerView.setAdapter(adapter);

        // 🔹 Log opening this activity
        logUserActivity("Opened Notifications");

        loadNotifications();
    }

    private void loadNotifications() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Notifications");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                list.clear();

                for (DataSnapshot ds : snapshot.getChildren()) {
                    String id = ds.getKey();
                    String title = ds.child("title").getValue(String.class);
                    String message = ds.child("message").getValue(String.class);
                    String links = ds.child("links").getValue(String.class); // Added links

                    list.add(0, new NotificationModel(id, title, message, links));
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ShowNotificationActivity.this,
                        "Failed to load notifications",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    // ===== LOG USER ACTIVITY =====
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
