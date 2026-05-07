package com.example.projectexpo;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.projectexpo.model.ActivityModel;
import com.example.projectexpo.model.NotificationModel;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.*;

import java.util.Map;

public class AdminActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageView menuIcon;

    private EditText edtTitle, edtMessage, edtLinks;
    private Button btnSend;

    DatabaseReference activityRef;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationAdmin);
        menuIcon = findViewById(R.id.menuIcon);

        edtTitle = findViewById(R.id.edtTitle);
        edtMessage = findViewById(R.id.edtMessage);
        edtLinks = findViewById(R.id.edtlink);
        btnSend = findViewById(R.id.btnSend);

        menuIcon.setOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));

        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_place) {
                startActivity(new Intent(AdminActivity.this, Show.class));
            } else if (id == R.id.nav_home) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else if (id == R.id.nav_logout) {
                showLogoutDialog();
            } else if (id == R.id.nav_users) {
                startActivity(new Intent(AdminActivity.this, AllUsersActivity.class));
            } else if (id == R.id.nav_log) {
                startActivity(new Intent(AdminActivity.this, Update.class));
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });

        btnSend.setOnClickListener(v -> addNotification());

        activityRef = FirebaseDatabase.getInstance().getReference("ActivityLog");
        listenUserActivity();
    }

    private void showLogoutDialog() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Are you sure you want to logout?")
                .setCancelable(false)
                .setPositiveButton("Yes", (d, w) -> {
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(AdminActivity.this, LoginActivity.class)
                            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
                    Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Cancel", (d, w) -> d.dismiss())
                .create();

        if (dialog.getWindow() != null)
            dialog.getWindow().setBackgroundDrawableResource(R.color.light_gray); // custom color

        dialog.show();
    }


    private void addNotification() {
        String title = edtTitle.getText().toString().trim();
        String message = edtMessage.getText().toString().trim();
        String links = edtLinks.getText().toString().trim();

        if (title.isEmpty() || message.isEmpty()) {
            Toast.makeText(this, "Fill all required fields", Toast.LENGTH_SHORT).show();
            return;
        }

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Notifications");
        String id = ref.push().getKey();

        NotificationModel model = new NotificationModel(id, title, message, links);
        ref.child(id).setValue(model).addOnSuccessListener(aVoid -> {
            Toast.makeText(this, "Notification added!", Toast.LENGTH_SHORT).show();
            edtTitle.setText("");
            edtMessage.setText("");
            edtLinks.setText("");
            showNotification(title, message);
        }).addOnFailureListener(e ->
                Toast.makeText(this, "Failed: " + e.getMessage(), Toast.LENGTH_SHORT).show());
    }

    private void listenUserActivity() {
        activityRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, String previousChildName) {
                for (DataSnapshot uidSnapshot : snapshot.getChildren()) {
                    for (DataSnapshot logSnapshot : uidSnapshot.getChildren()) {
                        Object value = logSnapshot.getValue();

                        if (value instanceof ActivityModel) {
                            // Normal case: ActivityModel object
                            ActivityModel m = (ActivityModel) value;
                            String userName = m.getName() != null ? m.getName() : uidSnapshot.getKey();
                            String action = m.getAction() != null ? m.getAction() : "Unknown Action";
                            showNotification("User Action", userName + " : " + action);
                        } else if (value instanceof Map) {
                            // When Firebase returns a Map, convert to ActivityModel
                            ActivityModel m = logSnapshot.getValue(ActivityModel.class);
                            if (m != null) {
                                String userName = m.getName() != null ? m.getName() : uidSnapshot.getKey();
                                String action = m.getAction() != null ? m.getAction() : "Unknown Action";
                                showNotification("User Action", userName + " : " + action);
                            }
                        } else if (value instanceof String) {
                            // If it is just a string (old entries)
                            String action = value.toString();
                            showNotification("User Action", uidSnapshot.getKey() + " : " + action);
                        } else {
                            // Fallback
                            showNotification("User Action", uidSnapshot.getKey() + " : Unknown Action");
                        }
                    }
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, String previousChildName) {
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, String previousChildName) {
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    private void showNotification(String title, String message) {
        String channelId = "admin_user_activity_channel";
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            android.app.NotificationChannel channel = new android.app.NotificationChannel(
                    channelId, "Admin User Activity", android.app.NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);
        }

        Intent intent = new Intent(this, AdminActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.drawable.ic_notification) // Swap icon instead of default
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);

        // Use a fixed ID to replace previous notification
        notificationManager.notify(1001, builder.build()); // 1001 = fixed ID
    }

}
