package com.example.ClassRoomAPI.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Cl2 {

    @OneToOne(mappedBy = "qualification")
    @JoinColumn(name = "fk_qualification", referencedColumnName = "id_qualification")
    @JsonManagedReference(value = "class-qualification")
    private Qualification qualification;

    @ManyToOne
    @JoinColumn(name="fk_course", referencedColumnName = "id_course")
    @JsonBackReference(value = "class-course")
    Course course;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idClass;

    @Column(length = 20)
    private String Name;

    public Cl2(){}

    public Cl2(Integer idClass, String name) {
        this.idClass = idClass;
        Name = name;
    }

    public Integer getIdClass() {
        return idClass;
    }

    public void setIdClass(Integer idClass) {
        this.idClass = idClass;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
