package com.company.demo.service;

import com.company.demo.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudentService {

    private ArrayList<StudentDto> studentDtoList;

    public StudentService() {
        this.studentDtoList = new ArrayList<>();
    }
    public boolean save(StudentDto studentDto) {
        for(StudentDto student : studentDtoList) {
            if(studentDto.getId()==student.getId()) {
                return false;
            }
        }
        return studentDtoList.add(studentDto);
    }

    public ArrayList<StudentDto> get() {
        return studentDtoList;
    }

    public Optional get(int id) {
        for(StudentDto student : studentDtoList) {
            if(student.getId()==id) {
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

    public boolean update(StudentDto studentDto){
        for(StudentDto student: studentDtoList){
            if(student.getId()==studentDto.getId()) {
                student.setId(studentDto.getId());
                student.setName(studentDto.getName());
                student.setAddress(studentDto.getAddress());
                student.setAge(studentDto.getAge());
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id){
        for(StudentDto student:studentDtoList){
            if(student.getId()==id){
                studentDtoList.remove(student);
                return true;
            }
        }
        return false;
    }


}
