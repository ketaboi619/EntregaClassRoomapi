package com.example.ClassRoomAPI.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.example.ClassRoomAPI.helpers.AttendanceStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "attendance")
public class Attendance {

    @ManyToOne
    @JoinColumn(name="fk_student", referencedColumnName = "id")
    @JsonBackReference(value = "attendance-student")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "fk_course", referencedColumnName = "idCourse")
    @JsonBackReference("attendance-course")
    private Course course;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "idAttendance")
    private Integer idAttendance;

    @Column(length = 20)
    private String Date;

    @Column
    @Enumerated(EnumType.STRING)
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

