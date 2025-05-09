package com.example.ClassRoomAPI.Repository;


import com.example.ClassRoomAPI.models.Cl2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassRepository extends JpaRepository <Cl2,Integer> {

}
