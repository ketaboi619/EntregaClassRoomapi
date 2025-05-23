package com.example.ClassRoomAPI.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "class")
public class Cl2 {

    @ManyToOne
    @JoinColumn(name = "fk_course", referencedColumnName = "idCourse")
    @JsonBackReference("class-course")
    private Course course;

    @OneToMany(mappedBy = "classs", cascade = CascadeType.ALL)
    @JsonManagedReference("class-qualification")
    private List<Qualification> qualification;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idClass")
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
