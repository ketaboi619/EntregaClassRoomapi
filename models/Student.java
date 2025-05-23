package com.example.ClassRoomAPI.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "student")

public class Student {


    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonManagedReference("student-qualification")
    private List<Qualification> qualifications;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonManagedReference("attendance-student")
    private List<Attendance> attendances;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonManagedReference("student-registration")
    private List<Registration> registrations;

    @OneToOne
    @JoinColumn(name = "fk_user_student", referencedColumnName = "id")
    @JsonManagedReference("student-user")
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Integer id;

    @Column(nullable = false)
    private Integer Grade;

    @Column
    private String Birthdate;

    @Column
    private String Adress;

    public Student(){
    }

    public Student(Integer id, String adress, String birthdate, Integer grade) {
        this.id = id;
        this.Adress = adress;
        this.Birthdate = birthdate;
        this.Grade = grade;
    }

    public Integer getIdStudent() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public String getBirthdate() {
        return Birthdate;
    }

    public void setBirthdate(String birthdate) {
        Birthdate = birthdate;
    }

    public Integer getGrade() {
        return Grade;
    }

    public void setGrade(Integer grade) {
        Grade = grade;
    }

}
