package com.taras_overmind.scheduleApp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.taras_overmind.scheduleApp.R;
import com.taras_overmind.scheduleApp.Utils;
import com.taras_overmind.scheduleApp.model.dto.LecturerDTO;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonalPageActivity extends AppCompatActivity {

    Button timetable, changePassword, logout;
    TextView name, position, email;

    FirebaseAuth mAuth;
    LecturerDTO lecturerDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_page);

        timetable = findViewById(R.id.btn_timetable);
        changePassword = findViewById(R.id.btn_change_password);
        logout = findViewById(R.id.btn_logout);
        name = findViewById(R.id.name);
        position = findViewById(R.id.position);
        email=findViewById(R.id.email);
        mAuth = FirebaseAuth.getInstance();

        String login = mAuth.getCurrentUser().getEmail();


         Utils.restAPI.getLecturerByEmail(login).enqueue(new Callback<LecturerDTO>() {
             @Override
             public void onResponse(Call<LecturerDTO> call, Response<LecturerDTO> response) {
                 lecturerDTO=response.body();
                 name.setText(lecturerDTO.getName());
                 position.setText(lecturerDTO.getPosition());
                 email.setText(lecturerDTO.getEmail());
             }

             @Override
             public void onFailure(Call<LecturerDTO> call, Throwable t) {
                 Toast.makeText(PersonalPageActivity.this, "Failed to load information", Toast.LENGTH_SHORT).show();
             }
         });

         timetable.setOnClickListener(v -> {
             Intent intent= new Intent(this, LecturerActivity.class);
             startActivity(intent);
         });
         changePassword.setOnClickListener(v -> {
             mAuth.sendPasswordResetEmail("Taras.Korolchuk.11@gmail.com");
             Toast.makeText(this, "Лист відправлено на вашу пошту", Toast.LENGTH_SHORT).show();
         });

         logout.setOnClickListener(v -> {
             mAuth.signOut();
             Intent intent = new Intent(this, LoginActivity.class);
             startActivity(intent);
             finish();
         });


    }
}