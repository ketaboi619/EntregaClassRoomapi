package com.example.ClassRoomAPI.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "course")
public class Course {


        @ManyToOne
        @JoinColumn(name = "fk_teacher", referencedColumnName = "idTeacher")
        @JsonBackReference("teacher-course")
        private Teacher teacher;

        @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
        @JsonManagedReference("course-registration")
        private List<Registration> registrations;

        @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
        @JsonManagedReference("class-course")
        private List<Cl2> classes;

        @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
        @JsonManagedReference("attendance-course")
        private List<Attendance> attendances;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "idCourse")
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
