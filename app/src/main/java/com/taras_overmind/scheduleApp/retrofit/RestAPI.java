package com.taras_overmind.scheduleApp.retrofit;

import com.taras_overmind.scheduleApp.model.dto.LecturerAppointmentDTO;
import com.taras_overmind.scheduleApp.model.dto.StudentAppointmentDTO;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestAPI {
    @GET("/lecturer")
    Call<List<LecturerAppointmentDTO>> getLecturerAppointment(@Query("email") String email, @Query("weekDay") int weekday);

    @GET("/student")
    Call<List<StudentAppointmentDTO>> getStudentAppointment(@Query("group_name") String group_name, @Query("weekDay") int weekDay);

    @GET("/smthing")
    Call<String> getSmthing();

    @GET("/faculties")
    Call<List<String>> getFaculties();

    @GET("/groups")
    Call<List<String>> getGroups(@Query("faculty_name") String faculty_name);
}
