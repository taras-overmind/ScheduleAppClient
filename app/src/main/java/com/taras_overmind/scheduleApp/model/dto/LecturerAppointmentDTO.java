package com.taras_overmind.scheduleApp.model.dto;

import lombok.Data;


public class LecturerAppointmentDTO {
    public LecturerAppointmentDTO(String number, String subject, String subject_type, String groups, String link) {
        this.number = number;
        this.subject = subject;
        this.subject_type = subject_type;
        this.groups = groups;
        this.link=link;
    }

    @Override
    public String toString() {
        return "LecturerAppointmentDTO{" +
                "number='" + number + '\'' +
                ", subject='" + subject + '\'' +
                ", subject_type='" + subject_type + '\'' +
                ", groups='" + groups + '\'' +
                ", link='" + link + '\'' +
                '}';
    }

    private String number;
    private String subject;
    private String subject_type;
    private String groups;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

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

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }
}