package com.springpro.jpa.dto;

import com.springpro.jpa.Constants.UserConstants;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class UserDto {
    private int id;
    private int mark;
    @Size(min=3, message = UserConstants.SizeName)
    private String name;
    private LocalDate dob;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
