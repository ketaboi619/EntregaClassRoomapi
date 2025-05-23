package com.example.ClassRoomAPI.controllers;

import com.example.ClassRoomAPI.Services.StudentServices;
import com.example.ClassRoomAPI.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/Students")
public class studentControllers {

    @Autowired
    StudentServices services;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Student info){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.services.saveStudent(info));
        }catch(Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> modify(@PathVariable Integer id, @RequestBody Student info){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.services.modifyStudent(info,id));
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
                    .body(this.services.findOneStudent(id));
        }catch(Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    //controlador para buscarlos todos
    @GetMapping
    public ResponseEntity<?> searchAll(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.services.findAllStudent());
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
                    .body(this.services.deleteStudent(id));
        }catch(Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

}
