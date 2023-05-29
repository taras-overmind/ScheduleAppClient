package com.taras_overmind.scheduleApp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.taras_overmind.scheduleApp.R;
import com.taras_overmind.scheduleApp.Utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StartActivity extends AppCompatActivity {

    private Spinner spinner_faculty, spinner_group;
    TextView textView;
    List<String> list1, list2;

    Button student_btn;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        student_btn=findViewById(R.id.btn_student);
        textView=findViewById(R.id.go_to_login);
        spinner_group = findViewById(R.id.spinner_select_group);
        spinner_faculty = findViewById(R.id.spinner_select_faculty);
        spinner_group.setVisibility(View.INVISIBLE);

        ArrayAdapter<String> adapter_faculty = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        ArrayAdapter<String> adapter_group = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adapter_faculty.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_group.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        Utils.restAPI.getFaculties().enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                list1 = response.body();
                list1.add(0, "Оберіть факультет");
                adapter_faculty.addAll(list1);
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Toast.makeText(StartActivity.this, "Failed to load faculties", Toast.LENGTH_SHORT).show();
            }
        });
        spinner_faculty.setSelection(0, false);
        spinner_faculty.setAdapter(adapter_faculty);


        spinner_faculty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!list1.get(position).equals("Оберіть факультет"))
                    Utils.restAPI.getGroups(list1.get(position)).enqueue(new Callback<List<String>>() {
                        @Override
                        public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                            spinner_group.setVisibility(View.VISIBLE);
                            adapter_group.clear();
                            list2 = response.body();
                            list2.add(0, "Оберіть групу");
                            adapter_group.addAll(list2);
                            spinner_group.setAdapter(adapter_group);

                            Toast.makeText(StartActivity.this, list1.get(position), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<List<String>> call, Throwable t) {

                        }
                    });
                else spinner_group.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_group.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(!list2.get(position).equals("Оберіть групу")){
                    sharedPreferences.edit().putString("group_name", list2.get(position)).apply();
                    Toast.makeText(StartActivity.this, list2.get(position), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        student_btn.setOnClickListener(v -> {
            Intent intent = new Intent(this, StudentActivity.class);
            startActivity(intent);
        });

        textView.setOnClickListener(v -> {
            Intent intent= new Intent(this, LoginActivity.class);
            startActivity(intent);
        });

    }
}