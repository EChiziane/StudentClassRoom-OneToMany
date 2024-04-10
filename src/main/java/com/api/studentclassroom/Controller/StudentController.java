package com.api.studentclassroom.Controller;

import com.api.studentclassroom.Dtos.StudentDto;
import com.api.studentclassroom.Model.StudentModel;
import com.api.studentclassroom.Services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600) // Enables Cross-Origin Resource Sharing (CORS)
@RequestMapping("/work-hour-logger-api")
public class StudentController {
    final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping
    public ResponseEntity<Object> saveStudent(@RequestBody @Valid StudentDto studentDto) {
        var studentModel = new StudentModel();
        BeanUtils.copyProperties(studentDto, studentModel);
        return ResponseEntity.status(HttpStatus.OK).body(studentService.saveStudent(studentModel));
    }

    @GetMapping
    public ResponseEntity<Object> GetAllStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> GetOneStudent(@PathVariable UUID id) {
        Optional<StudentModel> studentModelOptional = studentService.getOneStudent(id);
        if (studentModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No student found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentModelOptional);
    }
}
