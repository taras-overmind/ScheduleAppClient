package com.taras_overmind.scheduleApp.adapter;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.taras_overmind.scheduleApp.R;
import com.taras_overmind.scheduleApp.Utils;
import com.taras_overmind.scheduleApp.model.dto.LecturerAppointmentDTO;

import java.util.List;

public class LecturerAppointmentAdapter extends RecyclerView.Adapter<LecturerAppointmentHolder> {

    private final List<LecturerAppointmentDTO> list;
    private Dialog dialog;
    private String link;

    public LecturerAppointmentAdapter(List<LecturerAppointmentDTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public LecturerAppointmentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_lecturer_appointment_item, parent, false);
        final LecturerAppointmentHolder holder = new LecturerAppointmentHolder(view);


        dialog = new Dialog(parent.getContext());
        dialog.setContentView(R.layout.dialog_link);
        dialog.findViewById(R.id.link).setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(link));
            v.getContext().startActivity(intent);

        });

        Button edit_btn1 = dialog.findViewById(R.id.editButton);
        Button edit_btn2 = dialog.findViewById(R.id.edit);
        TextView linkText = dialog.findViewById(R.id.link);
        TextView editText = dialog.findViewById(R.id.editLinkField);
        edit_btn1.setOnClickListener(v -> {
            editText.setVisibility(View.VISIBLE);
            editText.setText(link);
            linkText.setVisibility(View.INVISIBLE);
            edit_btn1.setVisibility(View.INVISIBLE);
            edit_btn2.setVisibility(View.VISIBLE);
        });
        edit_btn2.setOnClickListener(v -> {
            editText.setVisibility(View.INVISIBLE);
            linkText.setVisibility(View.VISIBLE);
            edit_btn1.setVisibility(View.VISIBLE);
            edit_btn2.setVisibility(View.INVISIBLE);
            link = editText.getText().toString();
        });


        holder.item_appointment.setOnClickListener(
                v -> {
                    dialog.show();
                    editText.setVisibility(View.INVISIBLE);
                    linkText.setVisibility(View.VISIBLE);
                    edit_btn1.setVisibility(View.VISIBLE);
                    edit_btn2.setVisibility(View.INVISIBLE);
                    link = list.get(holder.getAdapterPosition()).getLink();
                }
        );
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull LecturerAppointmentHolder holder, int position) {
        LecturerAppointmentDTO lecturerAppointmentDTO = list.get(position);
        holder.subject.setText(lecturerAppointmentDTO.getSubject());
        holder.groups.setText(lecturerAppointmentDTO.getGroups());
        holder.subject_type.setText(lecturerAppointmentDTO.getSubject_type());
        holder.number.setText(lecturerAppointmentDTO.getNumber());
        holder.time.setText(Utils.getAppointmentTime(lecturerAppointmentDTO.getNumber()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
