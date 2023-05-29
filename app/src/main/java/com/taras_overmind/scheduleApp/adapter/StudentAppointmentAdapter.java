package com.taras_overmind.scheduleApp.adapter;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.taras_overmind.scheduleApp.R;
import com.taras_overmind.scheduleApp.Utils;
import com.taras_overmind.scheduleApp.model.dto.LecturerAppointmentDTO;
import com.taras_overmind.scheduleApp.model.dto.StudentAppointmentDTO;

import java.util.List;

public class StudentAppointmentAdapter extends RecyclerView.Adapter<StudentAppointmentHolder> {
    private final List<StudentAppointmentDTO> list;
    private Dialog dialog;
    private String link;

    public StudentAppointmentAdapter(List<StudentAppointmentDTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public StudentAppointmentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_student_appointment_item, parent, false);
        final StudentAppointmentHolder holder = new StudentAppointmentHolder(view);

        dialog=new Dialog(parent.getContext());
        dialog.setContentView(R.layout.dialog_link);
//        System.out.println(i);
//            link=list.get(holder.getAdapterPosition()).getLink();
        dialog.findViewById(R.id.linkTextView).setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(link));
            v.getContext().startActivity(intent);

        });


        holder.item_appointment.setOnClickListener(
                v ->{
                    dialog.show();
                    link=list.get(holder.getAdapterPosition()).getLink();
                }
//                Toast.makeText(parent.getContext(), list.get(2).getLink(), Toast.LENGTH_SHORT).show()

        );
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAppointmentHolder holder, int position) {
        StudentAppointmentDTO studentAppointmentDTO = list.get(position);
        holder.subject.setText(studentAppointmentDTO.getSubject());
        holder.groups.setText(studentAppointmentDTO.getLecturer_name());
        holder.subject_type.setText(studentAppointmentDTO.getSubject_type());
        holder.number.setText(studentAppointmentDTO.getNumber());
        holder.time.setText(Utils.getAppointmentTime(studentAppointmentDTO.getNumber()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
