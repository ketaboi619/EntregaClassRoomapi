package com.example.ClassRoomAPI.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;


@Entity
@Table(name = "qualification")
public class Qualification {

    @OneToOne
    @JoinColumn(name = "fk_student", referencedColumnName = "id_user")
    @JsonManagedReference(value = "teacher-user")
    private Student student;

    @ManyToOne
    @JoinColumn(name="fk_class", referencedColumnName = "id_class")
    @JsonBackReference(value = "class-qualification")
    Cl2 classs;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idQualification;

    @Column
    private Float Note;

    @Column
    private String EvaluationDate;

    public Qualification(){}

    public Qualification(Integer idQualification, Float note, String evaluationDate) {
        this.idQualification = idQualification;
        Note = note;
        EvaluationDate = evaluationDate;
    }

    public Integer getIdQualification() {
        return idQualification;
    }

    public void setIdQualification(Integer idQualification) {
        this.idQualification = idQualification;
    }

    public Float getNote() {
        return Note;
    }

    public void setNote(Float note) {
        Note = note;
    }

    public String getEvaluationDate() {
        return EvaluationDate;
    }

    public void setEvaluationDate(String evaluationDate) {
        EvaluationDate = evaluationDate;
    }
}
