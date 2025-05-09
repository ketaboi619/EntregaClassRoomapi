package com.example.ClassRoomAPI.Services;


import com.example.ClassRoomAPI.Repository.IRegistrationRepository;
import com.example.ClassRoomAPI.helpers.ApiMessage;
import com.example.ClassRoomAPI.models.Registration;
import com.example.ClassRoomAPI.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationServices {

    @Autowired
    IRegistrationRepository repository;

    public Registration saveRegistration(Registration registrationInfo)throws Exception{

        try{
            return this.repository.save(registrationInfo);

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

    public Registration modifyRegistration(Registration registrationInfo,Integer id)throws Exception{
        try{
            Optional<Registration> registrationSearch = this.repository.findById(id);
            if (registrationSearch.isPresent()){
                registrationSearch.get().setRegistrationDate(registrationInfo.getRegistrationDate());
                return this.repository.save(registrationSearch.get());
            }else {
                throw new Exception(ApiMessage.Registration_not_find.getText());
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Registration findOneRegistration (Integer id) throws Exception{
        try{
            Optional<Registration> registrationSearch = this.repository.findById(id);
            if (registrationSearch.isPresent()){
                return registrationSearch.get();
            }else {
                throw new Exception(ApiMessage.Registration_not_find.getText());
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<Registration> findAllRegistration() throws Exception{
        try{
            return this.repository.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public boolean deleteRegistration (Integer id) throws Exception{
        try{
            Optional<Registration> registrationSearch = this.repository.findById(id);
            if (registrationSearch.isPresent()) {
                this.repository.deleteById(id);
                return true;
            }else {
                throw new Exception(ApiMessage.Registration_not_find.getText());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}



