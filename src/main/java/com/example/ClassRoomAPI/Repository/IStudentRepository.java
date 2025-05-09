package com.example.ClassRoomAPI.Repository;

import com.example.ClassRoomAPI.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository <Student,Integer> {
}
