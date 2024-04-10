package com.api.studentclassroom.Dtos;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class StudentDto {
    @NotBlank
    private String name;
    @NotBlank
    private LocalDateTime dateOfBirth;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String email;
    @NotBlank
    private String address;
}

