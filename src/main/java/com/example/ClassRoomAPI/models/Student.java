package com.example.ClassRoomAPI.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Students")

public class Student {


    @OneToMany(mappedBy = "Registration")
    @JsonManagedReference
    private List<Registration> Registration;

    @ManyToOne
    @JoinColumn(name = "fk_idUser",referencedColumnName = "idUser")
    @JsonBackReference
    User user;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer idStudent;

    @Column(nullable = false)
    private Integer Grade;

    @Column
    private String Birthdate;

    @Column
    private String Adress;

    public Student(){
    }

    public Student(Integer idStudent, String adress, String birthdate, Integer grade) {
        this.idStudent = idStudent;
        this.Adress = adress;
        this.Birthdate = birthdate;
        this.Grade = grade;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
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
