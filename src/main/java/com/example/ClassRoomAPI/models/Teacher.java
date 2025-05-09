package com.example.ClassRoomAPI.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Teachers")

public class Teacher {

    @ManyToOne
    @JoinColumn(name = "fk_idUser", referencedColumnName = "idUser")
    @JsonBackReference User user;

    @OneToMany(mappedBy = "Course")
    @JsonBackReference
    private List<Course>Course;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
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
