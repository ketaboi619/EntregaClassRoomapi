package com.example.ClassRoomAPI.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "teacher")

public class Teacher {

    @OneToOne
    @JoinColumn(name = "fk_user_teacher", referencedColumnName = "id")
    @JsonManagedReference("teacher-user")
    private User user;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    @JsonManagedReference("teacher-course")
    private List<Course> courses;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,name = "idTeacher")
    private Integer idTeacher;

    @Column(length = 255, nullable = false)
    private String Specialism;

    public Teacher() {}

    public Teacher(Integer idTeacher, String specialism) {
        this.idTeacher = idTeacher;
        Specialism = specialism;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(Integer idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getSpecialism() {
        return Specialism;
    }

    public void setSpecialism(String specialism) {
        Specialism = specialism;
    }
}
