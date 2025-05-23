package com.example.ClassRoomAPI.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;


@Entity
@Table(name = "qualification")
public class Qualification {

    @ManyToOne
    @JoinColumn(name = "fk_student", referencedColumnName = "id")
    @JsonBackReference("student-qualification")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "fk_class", referencedColumnName = "idClass")
    @JsonBackReference("class-qualification")
    private Cl2 classs;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idQualification")
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
