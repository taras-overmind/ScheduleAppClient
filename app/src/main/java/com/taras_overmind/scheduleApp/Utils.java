package com.taras_overmind.scheduleApp;

import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.taras_overmind.scheduleApp.adapter.LecturerAppointmentAdapter;
import com.taras_overmind.scheduleApp.adapter.StudentAppointmentAdapter;
import com.taras_overmind.scheduleApp.model.dto.LecturerAppointmentDTO;
import com.taras_overmind.scheduleApp.model.dto.StudentAppointmentDTO;
import com.taras_overmind.scheduleApp.retrofit.RestAPI;
import com.taras_overmind.scheduleApp.retrofit.RetrofitService;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Utils {

    private static final HashMap<String, String> appointmentTime;
    public static final RestAPI restAPI;

    static {
        RetrofitService retrofitService = new RetrofitService();
        restAPI = retrofitService.getRetrofit().create(RestAPI.class);
        appointmentTime=new HashMap<>();
        appointmentTime.put("1", "08:40-10:15");
        appointmentTime.put("2", "10:35-12:10");
        appointmentTime.put("3", "12:20-13:55");
        appointmentTime.put("4", "14:05-15:40");
    }


    public static String getAppointmentTime(String number) {
        return appointmentTime.get(number);
    }

    public static void loadLecturerAppointments(RecyclerView recyclerView, String email, int weekDay) {
        restAPI.getLecturerAppointment(email, weekDay).enqueue(new Callback<List<LecturerAppointmentDTO>>() {
            @Override
            public void onResponse(Call<List<LecturerAppointmentDTO>> call, Response<List<LecturerAppointmentDTO>> response) {
                LecturerAppointmentAdapter lecturerAppointmentAdapter = new LecturerAppointmentAdapter(response.body());
                recyclerView.setAdapter(lecturerAppointmentAdapter);
            }

            @Override
            public void onFailure(Call<List<LecturerAppointmentDTO>> call, Throwable t) {
                Toast.makeText(recyclerView.getContext(), "Failed to load appointments", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public static void loadStudentAppointments(RecyclerView recyclerView, String group_name, int weekDay) {
        restAPI.getStudentAppointment(group_name, weekDay).enqueue(new Callback<List<StudentAppointmentDTO>>() {
            @Override
            public void onResponse(Call<List<StudentAppointmentDTO>> call, Response<List<StudentAppointmentDTO>> response) {
                StudentAppointmentAdapter studentAppointmentAdapter = new StudentAppointmentAdapter(response.body());
                recyclerView.setAdapter(studentAppointmentAdapter);
            }

            @Override
            public void onFailure(Call<List<StudentAppointmentDTO>> call, Throwable t) {
                Toast.makeText(recyclerView.getContext(), "Failed to load appointments", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
