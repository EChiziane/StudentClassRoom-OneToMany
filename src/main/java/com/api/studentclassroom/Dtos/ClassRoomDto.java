package com.api.studentclassroom.Dtos;

import jakarta.validation.constraints.NotBlank;

public class ClassRoomDto {
    @NotBlank
    private String className;
    @NotBlank
    private int numberOfStudents;

}
