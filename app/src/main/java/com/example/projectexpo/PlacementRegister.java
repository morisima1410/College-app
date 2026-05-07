package com.example.projectexpo;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectexpo.model.ActivityModel;
import com.example.projectexpo.model.PlacementUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.*;

import java.util.Calendar;
import java.util.HashMap;

public class PlacementRegister extends AppCompatActivity {

    EditText etEnrollment, etFullName, etDOB, etMobile, etEmail, etCGPA;
    RadioGroup rgGender, rgPH;
    Button btnRegister;
    Spinner spBranch;

    DatabaseReference databaseReference;
    String firebaseKey = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_placement_register);

        databaseReference = FirebaseDatabase.getInstance()
                .getReference("PlacementUsers");

        etEnrollment = findViewById(R.id.etEnrollment);
        etFullName = findViewById(R.id.etFullName);
        etDOB = findViewById(R.id.etDOB);
        etMobile = findViewById(R.id.etMobile);
        etEmail = findViewById(R.id.etEmail);
        etCGPA = findViewById(R.id.etper);

        rgGender = findViewById(R.id.rgGender);
        rgPH = findViewById(R.id.rgPH);
        spBranch = findViewById(R.id.spBranch);
        btnRegister = findViewById(R.id.btnRegister);

        // 🔥 SPINNER SETUP (100% WORKING)
        String[] branches = {
                "Select Branch",
                "Computer Engineering",
                "Civil Engineering",
                "Mechanical Engineering",
                "Electrical Engineering",
                "AutoMobile Engineering"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.spinner_selected_item,   // 👈 selected item layout
                branches
        );
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item); // 👈 dropdown layout
        spBranch.setAdapter(adapter);


        // DOB picker
        etDOB.setOnClickListener(v -> showDatePicker());

        // Update or Register
        firebaseKey = getIntent().getStringExtra("firebaseKey");
        if (firebaseKey != null) {
            btnRegister.setText("Update");
            loadOldData(firebaseKey);
        } else {
            btnRegister.setText("Register");
        }

        btnRegister.setOnClickListener(v -> {
            if (firebaseKey != null) {
                updateData(firebaseKey);
            } else {
                submitForm();
            }
        });
    }

    private void loadOldData(String key) {
        databaseReference.child(key)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (!snapshot.exists()) return;

                        PlacementUser user =
                                snapshot.getValue(PlacementUser.class);
                        if (user == null) return;

                        etEnrollment.setText(user.getEnrollment());
                        etFullName.setText(user.getFullName());
                        etDOB.setText(user.getDob());
                        etMobile.setText(user.getMobile());
                        etEmail.setText(user.getEmail());
                        etCGPA.setText(user.getCgpa());

                        if ("Male".equals(user.getGender()))
                            rgGender.check(R.id.rbMale);
                        else
                            rgGender.check(R.id.rbFemale);

                        if ("Yes".equals(user.getPhStatus()))
                            rgPH.check(R.id.rbPHYes);
                        else
                            rgPH.check(R.id.rbPHNo);

                        // 🔥 Spinner selection (SAFE)
                        spBranch.post(() -> {
                            for (int i = 0; i < spBranch.getCount(); i++) {
                                if (spBranch.getItemAtPosition(i)
                                        .toString()
                                        .equalsIgnoreCase(user.getBranch())) {
                                    spBranch.setSelection(i);
                                    break;
                                }
                            }
                        });
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
    }

    private void showDatePicker() {
        Calendar c = Calendar.getInstance();
        new DatePickerDialog(
                this,
                R.style.CommonWhiteDatePicker,
                (view, year, month, day) ->
                        etDOB.setText(day + "/" + (month + 1) + "/" + year),
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH)
        ).show();
    }

    private void submitForm() {
        String enrollment = etEnrollment.getText().toString().trim();
        String fullName = etFullName.getText().toString().trim();
        String dob = etDOB.getText().toString().trim();
        String mobile = etMobile.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String cgpa = etCGPA.getText().toString().trim();
        String branch = spBranch.getSelectedItem().toString();

        int genderId = rgGender.getCheckedRadioButtonId();
        int phId = rgPH.getCheckedRadioButtonId();

        String gender = genderId != -1
                ? ((RadioButton) findViewById(genderId)).getText().toString()
                : "";
        String ph = phId != -1
                ? ((RadioButton) findViewById(phId)).getText().toString()
                : "";

        if (TextUtils.isEmpty(enrollment) ||
                TextUtils.isEmpty(fullName) ||
                TextUtils.isEmpty(dob) ||
                TextUtils.isEmpty(mobile) ||
                TextUtils.isEmpty(email) ||
                TextUtils.isEmpty(gender) ||
                TextUtils.isEmpty(ph) ||
                TextUtils.isEmpty(cgpa) ||
                "Select Branch".equals(branch)) {

            Toast.makeText(this,
                    "Please fill all fields",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        String id = databaseReference.push().getKey();
        PlacementUser user = new PlacementUser(
                id, enrollment, fullName, gender,
                dob, ph, mobile, branch, email, cgpa
        );

        databaseReference.child(id).setValue(user)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(this,
                            "Registration Successful",
                            Toast.LENGTH_SHORT).show();
                    logUserActivity("Registered for Placement");
                    finish();
                })
                .addOnFailureListener(e ->
                        Toast.makeText(this,
                                e.getMessage(),
                                Toast.LENGTH_SHORT).show());
    }

    private void updateData(String key) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("enrollment", etEnrollment.getText().toString());
        map.put("fullName", etFullName.getText().toString());
        map.put("dob", etDOB.getText().toString());
        map.put("mobile", etMobile.getText().toString());
        map.put("email", etEmail.getText().toString());
        map.put("cgpa", etCGPA.getText().toString());
        map.put("branch", spBranch.getSelectedItem().toString());

        int genderId = rgGender.getCheckedRadioButtonId();
        if (genderId != -1)
            map.put("gender",
                    ((RadioButton) findViewById(genderId))
                            .getText().toString());

        int phId = rgPH.getCheckedRadioButtonId();
        if (phId != -1)
            map.put("phStatus",
                    ((RadioButton) findViewById(phId))
                            .getText().toString());

        databaseReference.child(key)
                .updateChildren(map)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(this,
                            "Updated Successfully",
                            Toast.LENGTH_SHORT).show();
                    logUserActivity("Updated Placement Details");
                    finish();
                })
                .addOnFailureListener(e ->
                        Toast.makeText(this,
                                e.getMessage(),
                                Toast.LENGTH_SHORT).show());
    }

    private void logUserActivity(String action) {
        FirebaseUser user =
                FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) return;

        ActivityModel model = new ActivityModel(
                user.getUid(),
                user.getDisplayName() != null
                        ? user.getDisplayName()
                        : "Unknown",
                action,
                System.currentTimeMillis()
        );

        FirebaseDatabase.getInstance()
                .getReference("ActivityLog")
                .child(user.getUid())
                .push()
                .setValue(model);
    }
}
