package com.taras_overmind.scheduleApp;

import static com.taras_overmind.scheduleApp.Utils.loadAppointments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taras_overmind.scheduleApp.retrofit.RetrofitService;


public class ThursdayFragment extends Fragment {

    private RecyclerView recyclerView;
    private View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_thursday, container, false);
        recyclerView=v.findViewById(R.id.lecturerAppointmentList_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RetrofitService retrofitService=new RetrofitService();
        loadAppointments(recyclerView, retrofitService, "karashchuk.mykola@knu.ua", 3);
        return v;
    }
}