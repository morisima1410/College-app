package com.example.projectexpo;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.example.projectexpo.Adapter.SliderAdapter;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ViewPager2 imageSlider;

    LinearLayout cardWebsite, cardERP, cardQuestion, cardNotes,
            cardFaculty, cardLocation, cardnotifaction, cardplacement;

    ImageView btnMenu;

    SharedPreferences sharedPreferences;

    // 🔥 Slider Handler
    Handler handler = new Handler();
    Runnable runnable;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("ProfilePrefs", MODE_PRIVATE);

        // ================= DRAWER =================
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        btnMenu = findViewById(R.id.menuIcon);

        btnMenu.setOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));

        // ================= SLIDER =================
        imageSlider = findViewById(R.id.imageSliders);

        int[] images = {
                R.drawable.slider1,
                R.drawable.slider2,
                R.drawable.slider3,
                R.drawable.slider4,
                R.drawable.slider5
        };

        SliderAdapter adapter = new SliderAdapter(images, this);
        imageSlider.setAdapter(adapter);

        runnable = new Runnable() {
            @Override
            public void run() {
                int current = imageSlider.getCurrentItem();

                if (current == images.length - 1) {
                    imageSlider.setCurrentItem(0, true);
                } else {
                    imageSlider.setCurrentItem(current + 1, true);
                }

                handler.postDelayed(this, 2000);
            }
        };

        handler.postDelayed(runnable, 2000);

        // 🔥 Smooth restart when user swipes
        imageSlider.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 2000);
            }
        });

        // ================= CARDS =================
        cardWebsite = findViewById(R.id.cardWebsite);
        cardERP = findViewById(R.id.cardERP);
        cardQuestion = findViewById(R.id.cardQuestion);
        cardNotes = findViewById(R.id.cardNotes);
        cardFaculty = findViewById(R.id.cardFaculty);
        cardLocation = findViewById(R.id.cardLocation);
        cardnotifaction = findViewById(R.id.cardnotifaction);
        cardplacement = findViewById(R.id.cardplacment);

        cardWebsite.setOnClickListener(v -> openUrl("https://sites.google.com/view/cusp-cte-guj/home"));
        cardERP.setOnClickListener(v -> openUrl("https://onlinesbi.sbi.bank.in/sbicollect/"));
        cardQuestion.setOnClickListener(v -> startActivity(new Intent(this, QuestionpaperActivity.class)));
        cardNotes.setOnClickListener(v -> startActivity(new Intent(this, NotesActivity.class)));
        cardFaculty.setOnClickListener(v -> startActivity(new Intent(this, FacultyActivity.class)));
        cardLocation.setOnClickListener(v -> openUrl("https://maps.app.goo.gl/DtGxeF5s6D65j7DN7"));
        cardnotifaction.setOnClickListener(v -> startActivity(new Intent(this, ShowNotificationActivity.class)));
        cardplacement.setOnClickListener(v -> startActivity(new Intent(this, PlacementRegister.class)));

        updateNavHeader();

        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_share) {
                shareApp();
            } else if (id == R.id.nav_logout) {
                logout();
            } else if (id == R.id.nav_help) {
                startActivity(new Intent(this, Aboutas.class));
            } else if (id == R.id.nav_profile) {
                startActivity(new Intent(this, ProfileActivity.class));
            } else if (id == R.id.nav_albums) {
                startActivity(new Intent(this, GalleryActivity.class));
            } else if (id == R.id.nav_lab) {
                startActivity(new Intent(this, LabActivity.class));
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });

        fetchLatestNotification();
    }

    private void updateNavHeader() {
        View headerView = navigationView.getHeaderView(0);
        TextView tvUserName = headerView.findViewById(R.id.tvUserName);
        TextView tvUserEmail = headerView.findViewById(R.id.tvUserEmail);
        ShapeableImageView profileImage = headerView.findViewById(R.id.profileImage);

        String name = sharedPreferences.getString("profile_name", "Guest User");
        String email = sharedPreferences.getString("profile_email", "Please login");
        String imageUriStr = sharedPreferences.getString("profile_image_uri", null);

        tvUserName.setText(name);
        tvUserEmail.setText(email);

        if (imageUriStr != null) {
            profileImage.setImageURI(Uri.parse(imageUriStr));
        } else {
            profileImage.setImageResource(R.drawable.ic_person);
        }

        profileImage.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            drawerLayout.closeDrawer(GravityCompat.START);
        });
    }

    private void openUrl(String url) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }

    private void logout() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Are you sure you want to logout?")
                .setPositiveButton("Yes", (d, w) -> {
                    FirebaseAuth.getInstance().signOut();
                    Intent i = new Intent(MainActivity.this, WelcomeActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);
                    Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Cancel", (d, w) -> d.dismiss())
                .create();

        dialog.show();
    }

    private void fetchLatestNotification() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Notifications");
        ref.limitToLast(1).get().addOnSuccessListener(snapshot -> {
            for (DataSnapshot data : snapshot.getChildren()) {
                String title = data.child("title").getValue(String.class);
                String message = data.child("message").getValue(String.class);
                showNotification(title, message);
            }
        });
    }
 
    private void showNotification(String title, String message) {
        String channelId = "college_channel";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    channelId, "College Notification",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            getSystemService(NotificationManager.class).createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true);

        NotificationManagerCompat.from(this)
                .notify((int) System.currentTimeMillis(), builder.build());
    }

    private void shareApp() {
        String link = "https://drive.google.com/file/d/1WQJ91Uj0t5tVYoY3IBr8U4HuNTE4X70U/view?usp=drivesdk";

        String message = "📱 College Application App\n\n"
                + "Get all college resources like Notes, Question Papers, Faculty Info & more in one place.\n\n"
                + "🔽 Download Now:\n" + link;

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(Intent.createChooser(intent, "Share App"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateNavHeader();
        handler.postDelayed(runnable, 3000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable); // 🔥 stop slider when not visible
    }
}