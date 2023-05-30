package com.taras_overmind.scheduleApp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LecturerDTO {
    private String name;
    private String position;
    private String email;

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public LecturerDTO() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LecturerDTO(String name, String position, String email) {
        this.name = name;
        this.position = position;
        this.email = email;
    }
}
