package com.example.ClassRoomAPI.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.example.ClassRoomAPI.helpers.UserType;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Users")

public class User {


    @OneToMany(mappedBy = "Student")
    @JsonManagedReference
    private List<Student>Student;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false,length = 100)
    private String name;

    @Column(nullable = true)
    private String email;

    @Column(nullable = false,length = 20)
    private String password;

    @Column
    private String phone;

    @Column
    private UserType userType;

    public User(){
    }

    public User(Integer id, String phone, String password, String email, String name, UserType userType) {
        this.id = id;
        this.phone = phone;
        this.password = password;
        this.email = email;
        this.name = name;
        this.userType = userType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
