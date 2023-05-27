package com.taras_overmind.scheduleApp;

import android.content.Context;
import android.util.Log;
import android.util.LogPrinter;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.taras_overmind.scheduleApp.retrofit.LecturerAPI;
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
        LecturerAPI lecturerAPI = retrofitService.getRetrofit().create(LecturerAPI.class);
        Log.d("TAG", lecturerAPI.getLecturerAppointment("karashchuk.mykola@knu.ua", 0).execute().body().get(0).toString());
//        assert (lecturerAPI.getLecturerAppointment(0).execute().body()).equals("");
//     System.err.println(lecturerAPI.getLecturerAppointment(0).execute().body());
//        Log.println(1, "<TAG>", lecturerAPI.getLecturerAppointment(0).execute().body().toString());
        Log.d("TAG", lecturerAPI.getLecturerAppointment("karashchuk.mykola@knu.ua", 0 ).execute().body().toString());
    }
}