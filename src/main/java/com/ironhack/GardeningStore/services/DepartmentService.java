package com.ironhack.GardeningStore.services;

import com.ironhack.GardeningStore.entities.Department;
import com.ironhack.GardeningStore.repositories.DepartmentRepository;
import com.ironhack.GardeningStore.repositories.ProductRepository;
import com.ironhack.GardeningStore.services.interfaces.DepartmentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@Service
public class DepartmentService implements DepartmentServiceInterface {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department addDepartment(String department) {
        if (department.isBlank() || departmentRepository.existsByName(department)) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Department already exists!");
        return departmentRepository.save(new Department(department, new ArrayList<>()));
    }
}
