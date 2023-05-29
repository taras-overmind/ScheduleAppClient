//package com.taras_overmind.scheduleApp.activity;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.os.Bundle;
//import android.widget.Toast;
//
//import com.taras_overmind.scheduleApp.R;
//import com.taras_overmind.scheduleApp.adapter.LecturerAppointmentAdapter;
//import com.taras_overmind.scheduleApp.model.dto.LecturerAppointmentDTO;
//import com.taras_overmind.scheduleApp.retrofit.RestAPI;
//import com.taras_overmind.scheduleApp.retrofit.RetrofitService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class LecturerActivity extends AppCompatActivity {
//    private RecyclerView recyclerView;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_lecturer);
//
//        recyclerView=findViewById(R.id.lecturerAppointmentList_recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        loadAppointments();
//    }
//    private void loadAppointments(){
//        RetrofitService retrofitService=new RetrofitService();
//        RestAPI restAPI =retrofitService.getRetrofit().create(RestAPI.class);
//        restAPI.getLecturerAppointment("karashchuk.mykola@knu.ua", 0).enqueue(new Callback<List<LecturerAppointmentDTO>>() {
//            @Override
//            public void onResponse(Call<List<LecturerAppointmentDTO>> call, Response<List<LecturerAppointmentDTO>> response) {
//                populateListView(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<List<LecturerAppointmentDTO>> call, Throwable t) {
//                Toast.makeText(LecturerActivity.this, call.toString(), Toast.LENGTH_SHORT).show();
//                System.out.println(call);
//                ArrayList<LecturerAppointmentDTO> list1 = new ArrayList<>();
//                list1.add(new LecturerAppointmentDTO("1", "math", "lecture", "K25, K26", "google.com/"));
//                list1.add(new LecturerAppointmentDTO("2", "chemistry", "practice", "K24, K26", "google.com/"));
//                populateListView(list1);
//            }
//        });
//    }
//    private void populateListView(List<LecturerAppointmentDTO> list){
//        LecturerAppointmentAdapter lecturerAppointmentAdapter= new LecturerAppointmentAdapter(list);
//        recyclerView.setAdapter(lecturerAppointmentAdapter);
//    }
//}