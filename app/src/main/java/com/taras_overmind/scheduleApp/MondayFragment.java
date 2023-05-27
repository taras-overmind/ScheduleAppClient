package com.taras_overmind.scheduleApp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.taras_overmind.scheduleApp.adapter.LecturerAppointmentAdapter;
import com.taras_overmind.scheduleApp.model.dto.LecturerAppointmentDTO;
import com.taras_overmind.scheduleApp.retrofit.LecturerAPI;
import com.taras_overmind.scheduleApp.retrofit.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MondayFragment extends Fragment {

    private RecyclerView recyclerView;
    private View v;

    @Nullable
    @Override
    public void onCreate(@Nullable Bundle savedInstances) {
        super.onCreate(savedInstances);
//        setContentView(R.layout.activity_lecturer);
//
//        recyclerView=findViewById(R.id.lecturerAppointmentList_recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        loadAppointments();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_monday, container, false);
        recyclerView=v.findViewById(R.id.lecturerAppointmentList_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RetrofitService retrofitService=new RetrofitService();
        loadAppointments(retrofitService);
        return v;
    }


    private void loadAppointments(RetrofitService retrofitService) {
        LecturerAPI lecturerAPI = retrofitService.getRetrofit().create(LecturerAPI.class);
        lecturerAPI.getLecturerAppointment().enqueue(new Callback<List<LecturerAppointmentDTO>>() {
            @Override
            public void onResponse(Call<List<LecturerAppointmentDTO>> call, Response<List<LecturerAppointmentDTO>> response) {
                populateListView(response.body());
            }

            @Override
            public void onFailure(Call<List<LecturerAppointmentDTO>> call, Throwable t) {
                Toast.makeText(getActivity(), call.toString(), Toast.LENGTH_SHORT).show();
                ArrayList<LecturerAppointmentDTO> list1 = new ArrayList<>();
                list1.add(new LecturerAppointmentDTO("1", "math", "lecture", "K25, K26", "google.com/"));
                list1.add(new LecturerAppointmentDTO("2", "chemistry", "practice", "K24, K26", "google.com/"));
                populateListView(list1);
            }
        });
    }

    private void populateListView(List<LecturerAppointmentDTO> list) {
        LecturerAppointmentAdapter lecturerAppointmentAdapter = new LecturerAppointmentAdapter(list);
        recyclerView.setAdapter(lecturerAppointmentAdapter);
    }
}