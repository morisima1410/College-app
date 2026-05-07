package com.example.projectexpo;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class feedbackActivity extends AppCompatActivity {

    EditText etName, etEnroll;
    RatingBar ratingBar;
    Button btnSubmit;

    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        etName = findViewById(R.id.etName);
        etEnroll = findViewById(R.id.etEnroll);
        ratingBar = findViewById(R.id.ratingBar);
        btnSubmit = findViewById(R.id.btnSubmit);

        ref = FirebaseDatabase.getInstance().getReference("Feedback");

        btnSubmit.setOnClickListener(v -> {

            String name = etName.getText().toString();
            String enroll = etEnroll.getText().toString();
            float rating = ratingBar.getRating();

            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(enroll) || rating == 0) {
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            String id = ref.push().getKey();

            FeedbackModel model = new FeedbackModel(name, enroll, rating);

            ref.child(id).setValue(model)
                    .addOnSuccessListener(unused -> {
                        Toast.makeText(this, "Submitted Successfully", Toast.LENGTH_SHORT).show();

                        etName.setText("");
                        etEnroll.setText("");
                        ratingBar.setRating(0);
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(this, "Failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    });
        });
    }
}