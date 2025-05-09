package com.example.ClassRoomAPI.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

public class Course {

    @OneToMany(mappedBy = "Registration")
    @JsonManagedReference
    private List<Registration> registration;


    @ManyToOne
    @JoinColumn(name = "fk_idTeacher",referencedColumnName = "idTeacher")
    @JsonBackReference Teacher teacher;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer idCourse;

    @Column(length = 20)
    private String Name;

    public Course(){}

    public Course(Integer idCourse, String name) {
        this.idCourse = idCourse;
        Name = name;
    }

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
