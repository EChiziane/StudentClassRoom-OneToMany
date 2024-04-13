package com.api.studentclassroom.Repository;

import com.api.studentclassroom.Model.ClassRoomModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoomModel, UUID> {
}
