package com.example.ClassRoomAPI.Repository;


import com.example.ClassRoomAPI.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeacherRepository extends JpaRepository<Teacher,Integer> {

}
