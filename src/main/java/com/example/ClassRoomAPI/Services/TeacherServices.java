package com.example.ClassRoomAPI.Services;

import com.example.ClassRoomAPI.Repository.ITeacherRepository;
import com.example.ClassRoomAPI.helpers.ApiMessage;
import com.example.ClassRoomAPI.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServices {

    @Autowired
    ITeacherRepository Repository;

    //save
    public Teacher saveTeacher(Teacher infoTeacher) throws Exception {
        try {
            return this.Repository.save(infoTeacher);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //modify
    public Teacher modifyTeacher(Integer id, Teacher infoTeacher) throws Exception {
        try {
            Optional<Teacher> teacherSearch = this.Repository.findById(id);

            if (teacherSearch.isPresent()) {
                teacherSearch.get().setSpecialism(infoTeacher.getSpecialism());
                return this.Repository.save(teacherSearch.get());

            } else {
                throw new Exception(ApiMessage.Teacher_not_find.getText());
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }


    }


    public Teacher findOneTecher(Integer id) throws Exception {
        try {
            Optional<Teacher> teacherSearch = this.Repository.findById(id);
            if (teacherSearch.isPresent()) {
                return teacherSearch.get();
            } else {
                throw new Exception(ApiMessage.Teacher_not_find.getText());
            }

        } catch (Exception error) {

            throw new Exception(error.getMessage());

        }


    }


    public List<Teacher> searchAllTeachers() throws Exception {
        try {
            return this.Repository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }



    public boolean deleteTeacher(Integer id)throws Exception{
        try{
            Optional<Teacher> teacherSearch=this.Repository.findById(id);
            if (teacherSearch.isPresent()){
                this.Repository.deleteById(id);
                return true;
            }else {
                throw new Exception(ApiMessage.Teacher_not_find.getText());
            }


        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }




}
