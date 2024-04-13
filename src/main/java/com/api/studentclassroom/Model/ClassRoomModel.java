package com.api.studentclassroom.Model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "TB_CLASSROOM")

public class ClassRoomModel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Column(nullable = false, length = 60)
    private String className;
    @Column(nullable = false, length = 10)
    private int numberOfStudents;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
