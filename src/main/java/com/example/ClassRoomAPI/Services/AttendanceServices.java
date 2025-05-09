package com.example.ClassRoomAPI.Services;

import com.example.ClassRoomAPI.Repository.IAttendanceRepository;
import com.example.ClassRoomAPI.helpers.ApiMessage;
import com.example.ClassRoomAPI.models.Attendance;
import com.example.ClassRoomAPI.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceServices {

    @Autowired
    IAttendanceRepository repository;


    public Attendance save(Attendance Info)throws Exception{

        try{
            return this.repository.save(Info);

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

    public Attendance modify(Attendance Info,Integer id)throws Exception{
        try{
            Optional<Attendance> Search = this.repository.findById(id);
            if (Search.isPresent()){
                Search.get().setDate(Info.getDate());
                return this.repository.save(Search.get());
            }else {
                throw new Exception(ApiMessage.Attendance_not_find.getText());
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Attendance findOne (Integer id) throws Exception{
        try{
            Optional<Attendance> Search = this.repository.findById(id);
            if (Search.isPresent()){
                return Search.get();
            }else {
                throw new Exception(ApiMessage.Attendance_not_find.getText());
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<Attendance> findAll() throws Exception{
        try{
            return this.repository.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public boolean delete (Integer id) throws Exception{
        try{
            Optional<Attendance> Search = this.repository.findById(id);
            if (Search.isPresent()) {
                this.repository.deleteById(id);
                return true;
            }else {
                throw new Exception(ApiMessage.Attendance_not_find.getText());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}



