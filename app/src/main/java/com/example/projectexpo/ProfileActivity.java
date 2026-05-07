package com.example.projectexpo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    ImageView profileImage;
    EditText etUserName, etUserEmail;
    Button btnSaveProfile;

    Uri selectedImageUri;
    SharedPreferences sharedPreferences;

    // 🔹 Image Picker
    private final ActivityResultLauncher<String> pickImageLauncher =
            registerForActivityResult(new ActivityResultContracts.GetContent(), uri -> {
                if (uri != null) {
                    selectedImageUri = uri;

                    try {
                        final int takeFlags = Intent.FLAG_GRANT_READ_URI_PERMISSION;
                        getContentResolver().takePersistableUriPermission(uri, takeFlags);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    profileImage.setImageURI(uri);

                    sharedPreferences.edit()
                            .putString("profile_image_uri", uri.toString())
                            .apply();
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileImage = findViewById(R.id.profileImage);
        etUserName = findViewById(R.id.etUserName);
        etUserEmail = findViewById(R.id.etUserEmail);
        btnSaveProfile = findViewById(R.id.btnSaveProfile);

        sharedPreferences = getSharedPreferences("ProfilePrefs", MODE_PRIVATE);

        loadProfile();

        // 🔹 Click → Pick Image
        profileImage.setOnClickListener(v ->
                pickImageLauncher.launch("image/*")
        );

        // 🔴 LONG CLICK → DELETE IMAGE
        profileImage.setOnLongClickListener(v -> {
            if (selectedImageUri != null) {
                showDeleteDialog();
            } else {
                Toast.makeText(this, "No image to delete", Toast.LENGTH_SHORT).show();
            }
            return true;
        });

        btnSaveProfile.setOnClickListener(v -> {
            String name = etUserName.getText().toString().trim();
            String email = etUserEmail.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Enter name and email", Toast.LENGTH_SHORT).show();
            } else {
                sharedPreferences.edit()
                        .putString("profile_name", name)
                        .putString("profile_email", email)
                        .apply();

                Toast.makeText(this, "Profile Saved!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    // 🔹 Load saved profile
    private void loadProfile() {
        String name = sharedPreferences.getString("profile_name", "");
        String email = sharedPreferences.getString("profile_email", "");
        String imageUriStr = sharedPreferences.getString("profile_image_uri", null);

        etUserName.setText(name);
        etUserEmail.setText(email);

        if (imageUriStr != null) {
            try {
                selectedImageUri = Uri.parse(imageUriStr);
                profileImage.setImageURI(selectedImageUri);
            } catch (Exception e) {
                profileImage.setImageResource(R.drawable.ic_person);
            }
        } else {
            profileImage.setImageResource(R.drawable.ic_person);
        }
    }

    // 🔴 Delete confirmation dialog
    private void showDeleteDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Delete Profile Image")
                .setMessage("Are you sure you want to delete this image?")
                .setPositiveButton("Yes", (dialog, which) -> deleteImage())
                .setNegativeButton("Cancel", null)
                .show();
    }

    // 🔹 Delete image logic
    private void deleteImage() {
        selectedImageUri = null;
        profileImage.setImageResource(R.drawable.ic_person);

        sharedPreferences.edit()
                .remove("profile_image_uri")
                .apply();

        Toast.makeText(this, "Profile image deleted", Toast.LENGTH_SHORT).show();
    }
}
