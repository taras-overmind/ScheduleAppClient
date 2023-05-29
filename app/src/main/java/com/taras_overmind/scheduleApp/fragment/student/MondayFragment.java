package com.taras_overmind.scheduleApp.fragment.student;

import static com.taras_overmind.scheduleApp.Utils.loadLecturerAppointments;
import static com.taras_overmind.scheduleApp.Utils.loadStudentAppointments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.taras_overmind.scheduleApp.R;
import com.taras_overmind.scheduleApp.retrofit.RetrofitService;


public class MondayFragment extends Fragment {

    private RecyclerView recyclerView;
    private View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_monday, container, false);
        recyclerView=v.findViewById(R.id.lecturerAppointmentList_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RetrofitService retrofitService=new RetrofitService();
//        loadAppointments(recyclerView, retrofitService, "karashchuk.mykola@knu.ua", 0);

//        FirebaseAuth.getInstance().sendPasswordResetEmail(FirebaseAuth.getInstance().getCurrentUser().getEmail());
        loadStudentAppointments(recyclerView, retrofitService, "ТТП-32", 0);

        return v;
    }

}