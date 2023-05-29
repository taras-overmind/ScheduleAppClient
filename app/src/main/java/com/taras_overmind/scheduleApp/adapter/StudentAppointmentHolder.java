package com.taras_overmind.scheduleApp.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.taras_overmind.scheduleApp.R;

public class StudentAppointmentHolder extends RecyclerView.ViewHolder {
    TextView subject, subject_type, groups, number;
    LinearLayout item_appointment;


    public StudentAppointmentHolder(@NonNull View itemView) {
        super(itemView);
        item_appointment=itemView.findViewById(R.id.item_student_appointment);
        subject=itemView.findViewById(R.id.subject);
        subject_type=itemView.findViewById(R.id.subject_type);
        groups=itemView.findViewById(R.id.lecturer);
        number=itemView.findViewById(R.id.number);
    }
}
