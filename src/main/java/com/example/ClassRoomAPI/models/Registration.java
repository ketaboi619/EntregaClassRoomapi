package com.example.ClassRoomAPI.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity

public class Registration {

    @ManyToOne
    @JoinColumn(name = "fk_idStudent", referencedColumnName = "idStudent")
    @JsonBackReference
    Student student;

    @ManyToOne
    @JoinColumn(name = "fk_idCourse", referencedColumnName = "idCourse")
    @JsonBackReference Course course;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idRegistration;

    @Column(length = 255)
    private String RegistrationDate;

    public Registration(){}

    public Registration(int idRegistration, String registrationDate) {
        this.idRegistration = idRegistration;
        RegistrationDate = registrationDate;
    }

    public Integer getIdRegistration() {
        return idRegistration;
    }

    public void setIdRegistration(Integer idRegistration) {
        this.idRegistration = idRegistration;
    }

    public String getRegistrationDate() {
        return RegistrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        RegistrationDate = registrationDate;
    }
}
