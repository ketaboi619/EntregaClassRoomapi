package com.example.ClassRoomAPI.helpers;

public enum ApiMessage {

    Student_not_find("the thing you looking for doesn´t exist"),
    Teacher_not_find("the thing you looking for doesn´t exist"),
    Class_not_find("the thing you looking for doesn´t exist"),
    Course_not_find("the thing you looking for doesn´t exist"),
    Qualification_not_find("the thing you looking for doesn´t exist"),
    Registration_not_find("the thing you looking for doesn´t exist"),
    Attendance_not_find("the thing you looking for doesn´t exist"),
    User_not_find("the thing you looking for doesn´t exist");
    //

    private String Text;

    ApiMessage(String text){
        this.Text = text;
    }

    public String getText(){
        return Text;
    }

}
