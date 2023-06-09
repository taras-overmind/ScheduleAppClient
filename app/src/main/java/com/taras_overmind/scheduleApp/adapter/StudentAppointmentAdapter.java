package com.taras_overmind.scheduleApp.adapter;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.taras_overmind.scheduleApp.R;
import com.taras_overmind.scheduleApp.Utils;
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

        dialog = new Dialog(parent.getContext());
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_link);
        dialog.findViewById(R.id.link).setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(link));
            v.getContext().startActivity(intent);
        });

        Button edit_btn1 = dialog.findViewById(R.id.editButton);
        edit_btn1.setText("Повернутись");
        edit_btn1.setOnClickListener(v -> {
            dialog.hide();
        });


        holder.item_appointment.setOnClickListener(
                v ->{
                    dialog.show();
                    link=list.get(holder.getAdapterPosition()).getLink();
                }
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
