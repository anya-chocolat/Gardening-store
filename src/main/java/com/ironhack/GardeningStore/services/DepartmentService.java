package com.ironhack.GardeningStore.services;

import com.ironhack.GardeningStore.repositories.DepartmentRepository;
import com.ironhack.GardeningStore.repositories.ProductRepository;
import com.ironhack.GardeningStore.services.interfaces.DepartmentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService implements DepartmentServiceInterface {

    @Autowired
    DepartmentRepository departmentRepository;

}
