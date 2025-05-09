package com.example.ClassRoomAPI.Services;

import com.example.ClassRoomAPI.Repository.IQualificationRepository;
import com.example.ClassRoomAPI.helpers.ApiMessage;
import com.example.ClassRoomAPI.models.Qualification;
import com.example.ClassRoomAPI.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QualificationServices {

    @Autowired
    IQualificationRepository repository;

    public Qualification saveQualification(Qualification qualificationInfo)throws Exception{

        try{
            return this.repository.save(qualificationInfo);

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

    public Qualification modifyQualification(Qualification Info,Integer id)throws Exception{
        try{
            Optional<Qualification> Search = this.repository.findById(id);
            if (Search.isPresent()){
                Search.get().setNote(Info.getNote());
                Search.get().setEvaluationDate(Info.getEvaluationDate());

                return this.repository.save(Search.get());
            }else {
                throw new Exception(ApiMessage.Qualification_not_find.getText());
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Qualification findOne (Integer id) throws Exception{
        try{
            Optional<Qualification> Search = this.repository.findById(id);
            if (Search.isPresent()){
                return Search.get();
            }else {
                throw new Exception(ApiMessage.Qualification_not_find.getText());
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<Qualification> findAll() throws Exception{
        try{
            return this.repository.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public boolean delete (Integer id) throws Exception{
        try{
            Optional<Qualification> Search = this.repository.findById(id);
            if (Search.isPresent()) {
                this.repository.deleteById(id);
                return true;
            }else {
                throw new Exception(ApiMessage.Qualification_not_find.getText());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}



