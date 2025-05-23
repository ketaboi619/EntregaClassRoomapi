package com.example.ClassRoomAPI.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "registration")
public class Registration {

    @ManyToOne
    @JoinColumn(name = "fk_student", referencedColumnName = "id")
    @JsonBackReference(value = "student-registration")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "fk_course", referencedColumnName = "idCourse")
    @JsonBackReference("course-registration")
    private Course course;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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
