package com.example.ClassRoomAPI.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.example.ClassRoomAPI.helpers.AttendanceStatus;
import jakarta.persistence.*;

@Entity
public class

Attendance {

    @ManyToOne
    @JoinColumn(name="fk_student", referencedColumnName = "id_student")
    @JsonBackReference(value = "attendance-student")
    Student student;

    @ManyToOne
    @JoinColumn(name = "fk_idCourse", referencedColumnName = "idCourse")
    @JsonBackReference
    Course course;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer idAttendance;

    @Column(length = 20)
    private String Date;

    @Column
    private AttendanceStatus AttendanceStatus;

    public Attendance(){

    }

    public Attendance(Integer idAttendance, String date) {
        this.idAttendance = idAttendance;
        Date = date;
    }


    public Integer getIdAttendance() {
        return idAttendance;
    }

    public void setIdAttendance(Integer idAttendance) {
        this.idAttendance = idAttendance;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}

