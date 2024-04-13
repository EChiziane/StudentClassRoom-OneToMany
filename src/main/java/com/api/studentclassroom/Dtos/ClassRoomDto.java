package com.api.studentclassroom.Dtos;

import jakarta.validation.constraints.NotBlank;

public class ClassRoomDto {
    @NotBlank
    private String className;
    @NotBlank
    private int numberOfStudents;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }
}
