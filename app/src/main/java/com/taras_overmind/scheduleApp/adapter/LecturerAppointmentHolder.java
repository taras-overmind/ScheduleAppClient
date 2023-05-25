package com.taras_overmind.scheduleApp.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.taras_overmind.scheduleApp.R;

public class LecturerAppointmentHolder extends RecyclerView.ViewHolder {

    TextView subject, subject_type, groups, number;


    public LecturerAppointmentHolder(@NonNull View itemView) {
        super(itemView);
        subject=itemView.findViewById(R.id.text_subject);
        subject_type=itemView.findViewById(R.id.text_subject_type);
        groups=itemView.findViewById(R.id.text_groups);
        number=itemView.findViewById(R.id.text_number);
    }
}
