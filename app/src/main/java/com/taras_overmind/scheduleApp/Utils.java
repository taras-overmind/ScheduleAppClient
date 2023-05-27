package com.taras_overmind.scheduleApp;

import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.taras_overmind.scheduleApp.adapter.LecturerAppointmentAdapter;
import com.taras_overmind.scheduleApp.model.dto.LecturerAppointmentDTO;
import com.taras_overmind.scheduleApp.retrofit.LecturerAPI;
import com.taras_overmind.scheduleApp.retrofit.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Utils {
    public static void loadAppointments(RecyclerView recyclerView, RetrofitService retrofitService, String email, int weekDay) {
        LecturerAPI lecturerAPI = retrofitService.getRetrofit().create(LecturerAPI.class);
        lecturerAPI.getLecturerAppointment(email, weekDay).enqueue(new Callback<List<LecturerAppointmentDTO>>() {
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

}
