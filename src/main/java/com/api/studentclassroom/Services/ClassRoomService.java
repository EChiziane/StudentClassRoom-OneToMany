package com.api.studentclassroom.Services;
import com.api.studentclassroom.Model.ClassRoomModel;
import com.api.studentclassroom.Repository.ClassRoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClassRoomService {
    final ClassRoomRepository classRoomRepository;

    public ClassRoomService(ClassRoomRepository classRoomRepository) {
        this.classRoomRepository = classRoomRepository;
    }

    @Transactional
    public Object saveClassRoom(ClassRoomModel classRoomModel) {
        return classRoomRepository.save(classRoomModel);
    }

    public Optional findClassRoomById(UUID id) {
        return classRoomRepository.findById(id);
    }

    public Object findAllClassRooms() {
        return classRoomRepository.findAll();
    }

    public void deleteClassRoomById(UUID id) {
        classRoomRepository.deleteById(id);
    }

    public Object updateClassRoom(ClassRoomModel classRoomModel) {
        return classRoomRepository.save(classRoomModel);
    }
}
