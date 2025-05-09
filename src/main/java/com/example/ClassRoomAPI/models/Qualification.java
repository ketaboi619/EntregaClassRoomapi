package com.example.ClassRoomAPI.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity

public class Qualification {

    @ManyToOne
    @JoinColumn(name = "fk_idStudent", referencedColumnName = "idStudent")
    @JsonBackReference
    Student student;

    @ManyToOne
    @JoinColumn(name = "fk_idClass", referencedColumnName = "idClass")
    @JsonBackReference
    Cl2 idclass;

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
