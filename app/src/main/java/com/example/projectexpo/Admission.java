package com.example.projectexpo;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.widget.*;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;

public class Admission extends AppCompatActivity {

    EditText name,father,dob,mobile,email,address;
    Spinner course;
    Button submit,upload;
    ImageView img;

    Bitmap bitmap;

    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission);

        name = findViewById(R.id.name);
        father = findViewById(R.id.father);
        dob = findViewById(R.id.dob);
        mobile = findViewById(R.id.mobile);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);
        course = findViewById(R.id.course);
        submit = findViewById(R.id.submit);
        upload = findViewById(R.id.upload);
        img = findViewById(R.id.img);

        ref = FirebaseDatabase.getInstance().getReference("Admissions");

        String[] courses = {"Select Course","Computer","Civil","Mechanical","Automobile","Electrical","CDDM","General"};

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        courses);

        course.setAdapter(adapter);

        dob.setOnClickListener(v -> {

            Calendar c = Calendar.getInstance();

            new DatePickerDialog(this,
                    (view,y,m,d) ->
                            dob.setText(d+"/"+(m+1)+"/"+y),
                    c.get(Calendar.YEAR),
                    c.get(Calendar.MONTH),
                    c.get(Calendar.DAY_OF_MONTH)).show();
        });

        upload.setOnClickListener(v -> {

            Intent i = new Intent(Intent.ACTION_GET_CONTENT);
            i.setType("image/*");
            startActivityForResult(i,100);
        });

        submit.setOnClickListener(v -> uploadData());
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,@Nullable Intent data) {
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode==100 && resultCode==RESULT_OK && data!=null){

            try{
                bitmap = MediaStore.Images.Media.getBitmap(
                        getContentResolver(),
                        data.getData());

                img.setImageBitmap(bitmap);

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    void uploadData(){

        if(bitmap==null){
            Toast.makeText(this,"Upload Photo",Toast.LENGTH_SHORT).show();
            return;
        }

        if(name.getText().toString().isEmpty()){
            name.setError("Required");
            return;
        }

        String id = ref.push().getKey();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,40,baos);

        String imageString =
                Base64.encodeToString(baos.toByteArray(),Base64.DEFAULT);

        ref.child(id).child("Name").setValue(name.getText().toString());
        ref.child(id).child("Father").setValue(father.getText().toString());
        ref.child(id).child("DOB").setValue(dob.getText().toString());
        ref.child(id).child("Mobile").setValue(mobile.getText().toString());
        ref.child(id).child("Email").setValue(email.getText().toString());
        ref.child(id).child("Address").setValue(address.getText().toString());
        ref.child(id).child("Course").setValue(course.getSelectedItem().toString());
        ref.child(id).child("Photo").setValue(imageString);

        Toast.makeText(this,"Admission Submitted",Toast.LENGTH_LONG).show();

        finish();
    }
}
