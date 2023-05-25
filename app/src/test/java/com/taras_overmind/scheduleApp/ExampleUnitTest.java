package com.taras_overmind.scheduleApp;

import org.junit.Test;

import static org.junit.Assert.*;

import com.taras_overmind.scheduleApp.retrofit.LecturerAPI;
import com.taras_overmind.scheduleApp.retrofit.RetrofitService;

import java.io.IOException;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws IOException {
        RetrofitService retrofitService = new RetrofitService();
        LecturerAPI lecturerAPI = retrofitService.getRetrofit().create(LecturerAPI.class);
        System.out.println(lecturerAPI.getSmthing().execute().body());
    }
}