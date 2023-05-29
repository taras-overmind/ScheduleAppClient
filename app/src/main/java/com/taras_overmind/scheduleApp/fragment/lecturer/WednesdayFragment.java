package com.taras_overmind.scheduleApp.fragment.lecturer;

import static com.taras_overmind.scheduleApp.Utils.loadLecturerAppointments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
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
        loadLecturerAppointments(recyclerView, retrofitService, FirebaseAuth.getInstance().getCurrentUser().getEmail(), 2);

        return v;
    }
}