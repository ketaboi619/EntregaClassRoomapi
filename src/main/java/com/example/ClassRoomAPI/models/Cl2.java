package com.example.ClassRoomAPI.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Cl2 {

    @ManyToOne
    @JoinColumn(name = "fk_idCourse", referencedColumnName = "idCourse")
    @JsonBackReference
    Course course;

    @OneToOne(mappedBy = "Qualification")
    @JsonBackReference
    private List<Qualification>qualifications;


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
