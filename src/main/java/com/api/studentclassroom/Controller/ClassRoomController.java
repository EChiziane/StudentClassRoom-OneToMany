package com.api.studentclassroom.Controller;

import com.api.studentclassroom.Dtos.ClassRoomDto;
import com.api.studentclassroom.Model.ClassRoomModel;
import com.api.studentclassroom.Services.ClassRoomService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600) // Enables Cross-Origin Resource Sharing (CORS)
@RequestMapping("/student-classroom") // Maps HTTP requests to a specific handler method
public class ClassRoomController {
    final ClassRoomService classRoomService;

    public ClassRoomController(ClassRoomService classRoomService) {
        this.classRoomService = classRoomService;
    }

    @PostMapping
    public ResponseEntity<Object> saveClassRoom(@RequestBody ClassRoomDto classRoomDto) {
        var classRoomModel = new ClassRoomModel();
        BeanUtils.copyProperties(classRoomDto, classRoomModel);
        return ResponseEntity.status(HttpStatus.OK).body(classRoomService.saveClassRoom(classRoomModel));
    }

    @GetMapping
    public ResponseEntity<Object> getAllClassRooms() {
        return ResponseEntity.ok().body(classRoomService.findAllClassRooms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getClassRoomById(@PathVariable UUID id) {
        Optional<ClassRoomModel> classRoomModelOptional = classRoomService.findClassRoomById(id);
        if (classRoomModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ClassRoom not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(classRoomModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClassRoomById(@PathVariable UUID id) {
        Optional<ClassRoomModel> classRoomModelOptional = classRoomService.findClassRoomById(id);
        if (classRoomModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ClassRoom not found");
        }
        classRoomService.deleteClassRoomById(id);
        return ResponseEntity.status(HttpStatus.OK).body("ClassRoom deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateClassRoomById(@PathVariable UUID id, @RequestBody ClassRoomDto classRoomDto) {
        Optional<ClassRoomModel> classRoomModelOptional = classRoomService.findClassRoomById(id);
        if (classRoomModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ClassRoom not found");
        }
        var classRoomModel = new ClassRoomModel();
        BeanUtils.copyProperties(classRoomDto, classRoomModel);
        classRoomModel.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(classRoomService.saveClassRoom(classRoomModel));
    }
}
