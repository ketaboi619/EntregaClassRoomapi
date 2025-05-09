package com.example.ClassRoomAPI.Services;

import com.example.ClassRoomAPI.Repository.IClassRepository;
import com.example.ClassRoomAPI.helpers.ApiMessage;
import com.example.ClassRoomAPI.models.Attendance;
import com.example.ClassRoomAPI.models.Cl2;
import com.example.ClassRoomAPI.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.Class;
import java.util.List;
import java.util.Optional;

public class ClassServices {

    @Autowired
    IClassRepository repository;

    public Cl2 save(Cl2 Info)throws Exception{

        try{
            return this.repository.save(Info);

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

    public Cl2 modify(Cl2 Info, Integer id)throws Exception{
        try{
            Optional<Cl2> Search = this.repository.findById(id);
            if (Search.isPresent()){
                Search.get().setName(Info.getName());
                return this.repository.save(Search.get());
            }else {
                throw new Exception(ApiMessage.Class_not_find.getText());
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Cl2 findOne (Integer id) throws Exception{
        try{
            Optional<Cl2> Search = this.repository.findById(id);
            if (Search.isPresent()){
                return Search.get();
            }else {
                throw new Exception(ApiMessage.Class_not_find.getText());
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<Cl2> findAll() throws Exception{
        try{
            return this.repository.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public boolean delete (Integer id) throws Exception{
        try{
            Optional<Cl2> Search = this.repository.findById(id);
            if (Search.isPresent()) {
                this.repository.deleteById(id);
                return true;
            }else {
                throw new Exception(ApiMessage.Class_not_find.getText());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}
