package com.taras_overmind.scheduleApp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.taras_overmind.scheduleApp.R;
import com.taras_overmind.scheduleApp.model.dto.LecturerAppointmentDTO;

import java.util.List;

public class LecturerAppointmentAdapter extends RecyclerView.Adapter<LecturerAppointmentHolder> {

    private final List<LecturerAppointmentDTO> list;

    public LecturerAppointmentAdapter(List<LecturerAppointmentDTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public LecturerAppointmentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_lecturer_appointment_item, parent, false);
        return new LecturerAppointmentHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull LecturerAppointmentHolder holder, int position) {
        LecturerAppointmentDTO lecturerAppointmentDTO=list.get(position);
        holder.subject.setText(lecturerAppointmentDTO.getSubject());
        holder.groups.setText(lecturerAppointmentDTO.getGroups());
        holder.subject_type.setText(lecturerAppointmentDTO.getSubject_type());
        holder.number.setText(lecturerAppointmentDTO.getNumber());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
