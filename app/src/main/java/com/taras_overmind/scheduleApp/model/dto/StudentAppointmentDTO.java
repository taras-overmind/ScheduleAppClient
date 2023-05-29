package com.taras_overmind.scheduleApp.model.dto;

import lombok.Data;

@Data
public class StudentAppointmentDTO {
    private String number;
    private String subject;
    private String subject_type;
    private String lecturer_name;
    private String link;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject_type() {
        return subject_type;
    }

    public void setSubject_type(String subject_type) {
        this.subject_type = subject_type;
    }

    public String getLecturer_name() {
        return lecturer_name;
    }

    public void setLecturer_name(String lecturer_name) {
        this.lecturer_name = lecturer_name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public StudentAppointmentDTO(String number, String subject, String subject_type, String lecturer_name, String link) {

        this.number = number;
        this.subject = subject;
        this.subject_type = subject_type;
        this.lecturer_name = lecturer_name;
        this.link = link;
    }
}
