package com.company.demo.controller;

import com.company.demo.dto.StudentDto;
import com.company.demo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    StudentService service;

    public StudentController(StudentService service) {
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
        Optional<StudentDto> studentDto = service.get(id);
        if(studentDto.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(studentDto.get());
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<String>saveStudent(@RequestBody StudentDto studentDto) {
        boolean save = service.save(studentDto);
        if(save){
            return ResponseEntity.ok("Student Saved");
        }
        return ResponseEntity.badRequest().body("Student Not Saved");
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity updateStudent(@RequestBody StudentDto studentDto){
        boolean update = service.update(studentDto);
        if(update){
            return ResponseEntity.ok("Student Updated");
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
