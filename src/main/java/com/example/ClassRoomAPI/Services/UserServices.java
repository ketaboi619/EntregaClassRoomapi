package com.example.ClassRoomAPI.Services;


import com.example.ClassRoomAPI.Repository.IUserRepository;
import com.example.ClassRoomAPI.helpers.ApiMessage;
import com.example.ClassRoomAPI.models.Attendance;
import com.example.ClassRoomAPI.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    IUserRepository repository;

    public User save(User Info)throws Exception{

        try{
            return this.repository.save(Info);

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

    public User modify(User Info,Integer id)throws Exception{
        try{
            Optional<User> Search = this.repository.findById(id);
            if (Search.isPresent()){
                Search.get().setName(Info.getName());
                Search.get().setEmail(Info.getEmail());
                Search.get().setPassword(Info.getPassword());
                Search.get().setPhone(Info.getPhone());
                Search.get().setUserType(Info.getUserType());
                return this.repository.save(Search.get());
            }else {
                throw new Exception(ApiMessage.User_not_find.getText());
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public User findOne (Integer id) throws Exception{
        try{
            Optional<User> Search = this.repository.findById(id);
            if (Search.isPresent()){
                return Search.get();
            }else {
                throw new Exception(ApiMessage.User_not_find.getText());
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<User> findAll() throws Exception{
        try{
            return this.repository.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public boolean delete (Integer id) throws Exception{
        try{
            Optional<User> Search = this.repository.findById(id);
            if (Search.isPresent()) {
                this.repository.deleteById(id);
                return true;
            }else {
                throw new Exception(ApiMessage.User_not_find.getText());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}
