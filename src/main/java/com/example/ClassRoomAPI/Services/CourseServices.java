package com.example.ClassRoomAPI.Services;


import com.example.ClassRoomAPI.Repository.ICourseRepository;
import com.example.ClassRoomAPI.helpers.ApiMessage;
import com.example.ClassRoomAPI.models.Course;
import com.example.ClassRoomAPI.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServices {

    @Autowired
    ICourseRepository repository;


    //save
    public Course saveCourse(Course courseInfo)throws Exception{
        try{
            return this.repository.save(courseInfo);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }





    //modify

    public Course modifyCourse (Course courseInfo,Integer id)throws Exception{
        try{
            Optional<Course> courseSearch = this.repository.findById(id);
            if(courseSearch.isPresent()){
                courseSearch.get().setName(courseInfo.getName());
                return this.repository.save(courseSearch.get());
            }else{
                throw new Exception(ApiMessage.Course_not_find.getText());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //findOne

   // public Course findOneCourse(Integer id)throws Exception{
     //   try{
       //     Optional<Course> courseSearch = this.repository.findById(id);
         //   if (courseSearch.isPresent()){
           //     return courseSearch.get();
            //}
        //}catch (Exception error){
           // throw new Exception(error.getMessage());

    public Course findOneCourse (Integer id) throws Exception{
        try{
            Optional<Course> courseSearch = this.repository.findById(id);
            if (courseSearch.isPresent()){
                return courseSearch.get();
            }else {
                throw new Exception(ApiMessage.Course_not_find.getText());
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }




    public List<Course> findAllCourse() throws Exception{
        try{
            return this.repository.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public boolean deleteCourse (Integer id) throws Exception{
        try{
            Optional<Course> CourseSearch = this.repository.findById(id);
            if (CourseSearch.isPresent()) {
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
