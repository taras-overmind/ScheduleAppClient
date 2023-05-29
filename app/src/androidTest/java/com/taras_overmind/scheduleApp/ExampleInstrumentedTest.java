package com.taras_overmind.scheduleApp;

import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.taras_overmind.scheduleApp.retrofit.RestAPI;
import com.taras_overmind.scheduleApp.retrofit.RetrofitService;

import java.io.IOException;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws IOException {
        RetrofitService retrofitService = new RetrofitService();
        RestAPI restAPI = retrofitService.getRetrofit().create(RestAPI.class);
        Log.d("TAG", restAPI.getLecturerAppointment("karashchuk.mykola@knu.ua", 0).execute().body().get(0).toString());
//        assert (lecturerAPI.getLecturerAppointment(0).execute().body()).equals("");
//     System.err.println(lecturerAPI.getLecturerAppointment(0).execute().body());
//        Log.println(1, "<TAG>", lecturerAPI.getLecturerAppointment(0).execute().body().toString());
        Log.d("TAG", restAPI.getLecturerAppointment("karashchuk.mykola@knu.ua", 0 ).execute().body().toString());
    }
}