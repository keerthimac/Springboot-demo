package com.company.demo.repo;

import com.company.demo.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<StudentEntity,Integer> {
}
