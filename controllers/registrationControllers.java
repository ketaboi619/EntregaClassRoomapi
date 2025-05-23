package com.example.ClassRoomAPI.controllers;

import com.example.ClassRoomAPI.Services.RegistrationServices;
import com.example.ClassRoomAPI.models.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Registration")
public class registrationControllers {

    @Autowired
    RegistrationServices services;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Registration info){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.services.saveRegistration(info));
        }catch(Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> modify(@PathVariable Integer id, @RequestBody Registration info){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.services.modifyRegistration(info,id));
        }catch(Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findbyid(@PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.services.findOneRegistration(id));
        }catch(Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }


    @GetMapping
    public ResponseEntity<?> searchAll(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.services.findAllRegistration());
        }catch(Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.services.deleteRegistration(id));
        }catch(Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

}
