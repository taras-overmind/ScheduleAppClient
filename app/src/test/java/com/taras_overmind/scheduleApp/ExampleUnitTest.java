package com.taras_overmind.scheduleApp;

import org.junit.Test;

import com.taras_overmind.scheduleApp.retrofit.RestAPI;
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
        RestAPI restAPI = retrofitService.getRetrofit().create(RestAPI.class);
        System.out.println(restAPI.getSmthing().execute().body());
    }
}