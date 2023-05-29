package com.taras_overmind.scheduleApp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.taras_overmind.scheduleApp.R;

public class LoginActivity extends AppCompatActivity {

    private TextView editEmailText, editPasswordText;
    private Button button;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        if(mAuth.getCurrentUser()!=null){
//            Intent intent=new Intent(getApplicationContext(), MainActivity.class);
//            startActivity(intent);
//            finish();
//        }

        editEmailText = findViewById(R.id.email);
        editPasswordText = findViewById(R.id.password);
        button = findViewById(R.id.btn_login);
        mAuth = FirebaseAuth.getInstance();

        button.setOnClickListener(v -> {
            String email, password;
            email = editEmailText.getText().toString();
            password = editPasswordText.getText().toString();

            if (email.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Enter email", Toast.LENGTH_LONG).show();
                return;
            }
            if (TextUtils.isEmpty(password)) {
                Toast.makeText(LoginActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                return;
            }
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
//                        finish();
                    } else
                        Toast.makeText(LoginActivity.this, "Authentication failed", Toast.LENGTH_LONG).show();
                }
            });
        });
    }
}