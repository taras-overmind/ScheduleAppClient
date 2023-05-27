package com.taras_overmind.scheduleApp.retrofit;

import com.taras_overmind.scheduleApp.model.dto.LecturerAppointmentDTO;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LecturerAPI {
    @GET("/lecturer")
    Call<List<LecturerAppointmentDTO>> getLecturerAppointment(@Query("email") String email, @Query("weekDay") int weekday);

    @GET("/smthing")
    Call<String> getSmthing();
}
