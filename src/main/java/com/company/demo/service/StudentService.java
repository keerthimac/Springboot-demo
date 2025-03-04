package com.company.demo.service;

import com.company.demo.dto.StudentDto;

import java.util.Optional;

public interface StudentService {
    StudentDto save(StudentDto studentDto);
    StudentDto get(int id);
    StudentDto update(StudentDto studentDto);
    boolean delete(int id);
}
