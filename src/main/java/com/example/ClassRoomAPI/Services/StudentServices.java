package com.example.ClassRoomAPI.Services;


import com.example.ClassRoomAPI.Repository.IStudentRepository;
import com.example.ClassRoomAPI.helpers.ApiMessage;
import com.example.ClassRoomAPI.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {

    @Autowired
    IStudentRepository repository;

    //save
    public Student saveStudent(Student studentInfo)throws Exception{

        try{
            return this.repository.save(studentInfo);

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

    public Student modifyStudent(Student studentInfo,Integer id)throws Exception{
            try{
                Optional<Student> studentSearch = this.repository.findById(id);
                if (studentSearch.isPresent()){
                    studentSearch.get().setAdress(studentInfo.getAdress());
                    studentSearch.get().setGrade(studentInfo.getGrade());
                    studentSearch.get().setBirthdate(studentInfo.getBirthdate());
                    return this.repository.save(studentSearch.get());
                }else {
                    throw new Exception(ApiMessage.Student_not_find.getText());
                }

            } catch (Exception error) {
                throw new Exception(error.getMessage());
            }
    }

    public Student findOneStudent (Integer id) throws Exception{
        try{
            Optional<Student> studentSearch = this.repository.findById(id);
                    if (studentSearch.isPresent()){
                        return studentSearch.get();
                    }else {
                        throw new Exception(ApiMessage.Student_not_find.getText());
                    }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List <Student> findAllStudent() throws Exception{
        try{
            return this.repository.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public boolean deleteStudent (Integer id) throws Exception{
        try{
            Optional<Student> studentSearch = this.repository.findById(id);
            if (studentSearch.isPresent()) {
                this.repository.deleteById(id);
                return true;
            }else {
                throw new Exception(ApiMessage.Student_not_find.getText());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    
}
