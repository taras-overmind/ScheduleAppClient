package com.taras_overmind.scheduleApp.retrofit;

import com.taras_overmind.scheduleApp.model.dto.LecturerAppointmentDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LecturerAPI {
    @GET("/lecturer?lecturer_id=1&weekDay=0")
    Call<List<LecturerAppointmentDTO>> getLecturerAppointment();

    @GET("/smthing")
    Call<String> getSmthing();

}
