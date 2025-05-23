package com.example.ClassRoomAPI.controllers;

import com.example.ClassRoomAPI.Services.ClassServices;
import com.example.ClassRoomAPI.models.Attendance;
import com.example.ClassRoomAPI.models.Cl2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Cl2")
public class classControllers {

    @Autowired
    ClassServices services;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Cl2 info){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.services.save(info));
        }catch(Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> modify(@PathVariable Integer id, @RequestBody Cl2 info){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.services.modify(info,id));
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
                    .body(this.services.findOne(id));
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
                    .body(this.services.findAll());
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
                    .body(this.services.delete(id));
        }catch(Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

}
