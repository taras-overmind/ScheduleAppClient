package com.taras_overmind.scheduleApp.fragment.student;

import static com.taras_overmind.scheduleApp.Utils.loadStudentAppointments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.taras_overmind.scheduleApp.R;
import com.taras_overmind.scheduleApp.retrofit.RetrofitService;

public class WednesdayFragment extends Fragment {


    private RecyclerView recyclerView;
    private View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_wednesday, container, false);
        recyclerView=v.findViewById(R.id.lecturerAppointmentList_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RetrofitService retrofitService=new RetrofitService();
//        loadAppointments(recyclerView, retrofitService, "karashchuk.mykola@knu.ua", 2);
        SharedPreferences sharedPreferences = inflater.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        loadStudentAppointments(recyclerView, sharedPreferences.getString("group_name", ""), 2);

        return v;
    }
}