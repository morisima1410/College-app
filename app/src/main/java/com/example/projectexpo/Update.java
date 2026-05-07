package com.example.projectexpo;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectexpo.Adapter.ActivityAdapter;
import com.example.projectexpo.model.ActivityModel;
import com.google.firebase.database.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Update extends AppCompatActivity {

    ListView listUserActivity;
    ArrayList<String> list;
    ArrayList<String> activityKeys; // Firebase keys
    ArrayList<String> activityUIDs; // User UIDs
    DatabaseReference refActivity, refUsers;

    private long lastClickTime = 0;
    private int lastClickedPosition = -1;

    ActivityAdapter adapter; // Custom adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        listUserActivity = findViewById(R.id.listUserActivity);
        list = new ArrayList<>();
        activityKeys = new ArrayList<>();
        activityUIDs = new ArrayList<>();

        refActivity = FirebaseDatabase.getInstance().getReference("ActivityLog");
        refUsers = FirebaseDatabase.getInstance().getReference("Users");

        // Initialize custom adapter
        adapter = new ActivityAdapter(this, list);
        listUserActivity.setAdapter(adapter);

        // Double-click to delete
        listUserActivity.setOnItemClickListener((parent, view, position, id) -> {
            long clickTime = System.currentTimeMillis();
            if (lastClickedPosition == position && (clickTime - lastClickTime) < 500) {
                new AlertDialog.Builder(Update.this)
                        .setTitle("Delete Activity")
                        .setMessage("Do you want to delete this activity?")
                        .setPositiveButton("Yes", (dialog, which) -> deleteActivity(position))
                        .setNegativeButton("No", null)
                        .show();
            }
            lastClickedPosition = position;
            lastClickTime = clickTime;
        });

        // Handle delete via trash icon
        adapter.setOnDeleteClickListener(position -> {
            new AlertDialog.Builder(Update.this)
                    .setTitle("Delete Activity")
                    .setMessage("Do you want to delete this activity?")
                    .setPositiveButton("Yes", (dialog, which) -> deleteActivity(position))
                    .setNegativeButton("No", null)
                    .show();
        });

        loadData();
    }

    private void loadData() {
        refActivity.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                list.clear();
                activityKeys.clear();
                activityUIDs.clear();

                for (DataSnapshot user : snapshot.getChildren()) {
                    String uid = user.getKey();

                    refUsers.child(uid).child("name").get().addOnSuccessListener(nameSnap -> {

                        String userName = nameSnap.getValue(String.class);
                        if (userName == null) userName = "Unknown User";

                        for (DataSnapshot logs : user.getChildren()) {
                            ActivityModel m = logs.getValue(ActivityModel.class);
                            if (m == null) continue;

                            String date = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a")
                                    .format(new Date(m.getTime()));

                            String item = "Name : " + userName +
                                    "\nActivity : " + m.getAction() +
                                    "\nTime : " + date;

                            list.add(item);
                            activityKeys.add(logs.getKey());
                            activityUIDs.add(uid);
                        }

                        adapter.notifyDataSetChanged(); // refresh adapter
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    private void deleteActivity(int position) {
        String uid = activityUIDs.get(position);
        String key = activityKeys.get(position);

        refActivity.child(uid).child(key).removeValue()
                .addOnSuccessListener(aVoid -> Toast.makeText(Update.this, "Deleted!", Toast.LENGTH_SHORT).show())
                .addOnFailureListener(e -> Toast.makeText(Update.this, "Failed: " + e.getMessage(), Toast.LENGTH_SHORT).show());
    }
}
