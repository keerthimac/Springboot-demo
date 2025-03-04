package com.company.demo.service.impl;

import com.company.demo.dto.StudentDto;
import com.company.demo.entity.StudentEntity;
import com.company.demo.repo.StudentRepo;
import com.company.demo.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

//    private ArrayList<StudentDto> studentDtoList;

    private StudentRepo repo;

    public StudentServiceImpl(StudentRepo repo) {
//        this.studentDtoList = new ArrayList<>();
        this.repo = repo;
    }

    public StudentDto save(StudentDto studentDto) {
        StudentEntity entity = new StudentEntity();
        entity.setName(studentDto.getName());
        entity.setAddress(studentDto.getAddress());
        entity.setAge(studentDto.getAge());

        try {
            StudentEntity save = repo.save(entity);
            studentDto.setId(save.getId());
            return studentDto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<StudentDto> get() {
        Iterable<StudentEntity> all = repo.findAll();
        ArrayList<StudentDto> studentDtoList = new ArrayList<>();
        for (StudentEntity studentEntity : all) {
            StudentDto studentDto = new StudentDto();
            studentDto.setId(studentEntity.getId());
            studentDto.setName(studentEntity.getName());
            studentDto.setAddress(studentEntity.getAddress());
            studentDto.setAge(studentEntity.getAge());
            studentDtoList.add(studentDto);
        }
        return studentDtoList;
    }

    public StudentDto get(int id) {
        Optional<StudentEntity> byId = repo.findById(id);
        if (byId.isPresent()) {
            StudentDto studentDto = new StudentDto();
            studentDto.setId(byId.get().getId());
            studentDto.setName(byId.get().getName());
            studentDto.setAddress(byId.get().getAddress());
            studentDto.setAge(byId.get().getAge());
            return studentDto;
        }
        return null;
    }

    public StudentDto update(StudentDto studentDto) {
        Optional<StudentEntity> student = repo.findById(studentDto.getId());
        if (student.isPresent()) {
            if (studentDto.getName() != null) {
                student.get().setName(studentDto.getName());
            }
            if (studentDto.getAddress() != null) {
                student.get().setAddress(studentDto.getAddress());
            }
            if (studentDto.getAge() != null) {
                student.get().setAge(studentDto.getAge());
            }
            StudentEntity save = repo.save(student.get());
            studentDto.setId(save.getId());
            studentDto.setName(save.getName());
            studentDto.setAddress(save.getAddress());
            studentDto.setAge(save.getAge());

            return studentDto;
        }
        return null;
    }

    public boolean delete(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

}
