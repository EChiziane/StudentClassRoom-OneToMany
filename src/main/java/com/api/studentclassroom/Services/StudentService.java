package com.api.studentclassroom.Services;

import com.api.studentclassroom.Model.StudentModel;
import com.api.studentclassroom.Repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public Object saveStudent(StudentModel studentModel) {
        return studentRepository.save(studentModel);
    }

    public Object getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<StudentModel> getOneStudent(UUID id) {
        return studentRepository.findById(id);
    }

    public void DeleteStudent(UUID id) {
        studentRepository.deleteById(id);
    }
}
