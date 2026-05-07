package com.example.projectexpo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectexpo.model.UserModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    EditText etName, etEmail, etPassword;
    Button btnRegister;
    TextView tvLogin;

    FirebaseAuth firebaseAuth;
    DatabaseReference userRef;

    // 🔥 CHANGE YOUR ADMIN EMAIL HERE
    private static final String ADMIN_EMAIL = "sima14@gmail.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.btnRegister);
        tvLogin = findViewById(R.id.tvLogin);

        firebaseAuth = FirebaseAuth.getInstance();
        userRef = FirebaseDatabase.getInstance().getReference("Users");

        btnRegister.setOnClickListener(v -> registerUser());
        tvLogin.setOnClickListener(v -> startActivity(new Intent(RegisterActivity.this, LoginActivity.class)));
    }

    private void registerUser() {

        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (TextUtils.isEmpty(name)) {
            etName.setError("Enter full name");
            return;
        }
        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Enter email");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Enter password");
            return;
        }

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {

                    if (task.isSuccessful()) {

                        FirebaseUser user = firebaseAuth.getCurrentUser();
                        String userId = user.getUid();

                        // 🔥 SAVE NAME IN FIREBASE AUTH PROFILE
                        UserProfileChangeRequest profile =
                                new UserProfileChangeRequest.Builder()
                                        .setDisplayName(name)
                                        .build();
                        user.updateProfile(profile);

                        // ROLE
                        String role = email.equalsIgnoreCase(ADMIN_EMAIL)
                                ? "admin"
                                : "user";

                        UserModel model = new UserModel(name, email, role);

                        userRef.child(userId).setValue(model)
                                .addOnCompleteListener(dbTask -> {

                                    if (dbTask.isSuccessful()) {

                                        Toast.makeText(this,
                                                "Registration Successful",
                                                Toast.LENGTH_SHORT).show();

                                        // 🔥 DIRECT TO MAIN / ADMIN (NO LOGIN AGAIN)
                                        if (role.equals("admin")) {
                                            startActivity(new Intent(this, AdminActivity.class));
                                        } else {
                                            startActivity(new Intent(this, MainActivity.class));
                                        }
                                        finish();

                                    } else {
                                        Toast.makeText(this,
                                                "DB Error: " + dbTask.getException().getMessage(),
                                                Toast.LENGTH_LONG).show();
                                    }
                                });

                    } else {
                        Toast.makeText(this,
                                "Registration Failed: " + task.getException().getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                });
    }


}
