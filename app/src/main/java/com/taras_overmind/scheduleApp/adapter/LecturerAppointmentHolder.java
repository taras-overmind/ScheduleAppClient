package com.taras_overmind.scheduleApp.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.taras_overmind.scheduleApp.R;

public class LecturerAppointmentHolder extends RecyclerView.ViewHolder {

    TextView subject, subject_type, groups, number, time;
    LinearLayout item_appointment;


    public LecturerAppointmentHolder(@NonNull View itemView) {
        super(itemView);
        item_appointment=itemView.findViewById(R.id.item_appointment);
        subject=itemView.findViewById(R.id.text_subject);
        subject_type=itemView.findViewById(R.id.text_subject_type);
        groups=itemView.findViewById(R.id.text_groups);
        number=itemView.findViewById(R.id.text_number);
        time=itemView.findViewById(R.id.time);
    }
}
