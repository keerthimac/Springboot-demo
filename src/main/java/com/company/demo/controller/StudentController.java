package com.company.demo.controller;

import com.company.demo.dto.StudentDto;
import com.company.demo.service.impl.StudentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    StudentServiceImpl service;

    public StudentController(StudentServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ArrayList<StudentDto>> getStudent() {
        ArrayList<StudentDto> studentDtoList = service.get();
        if(studentDtoList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(studentDtoList);
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable int id){
        StudentDto studentDto = service.get(id);
        if(studentDto==null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(studentDto);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity saveStudent(@RequestBody StudentDto studentDto) {
        StudentDto saved = service.save(studentDto);
        if(saved!=null){
            return ResponseEntity.ok(saved);
        }
        return ResponseEntity.badRequest().body("Student Not Saved");
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity updateStudent(@RequestBody StudentDto studentDto){
        StudentDto updated = service.update(studentDto);
        if(updated!=null){
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id){
        boolean delete = service.delete(id);
        if(delete){
           return ResponseEntity.ok("Student Deleted");
        }
        return ResponseEntity.badRequest().body("Student Not Found");
    }


}
