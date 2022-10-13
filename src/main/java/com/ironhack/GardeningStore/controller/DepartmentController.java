package com.ironhack.GardeningStore.controller;

import com.ironhack.GardeningStore.controller.interfaces.DepartmentControllerInterface;
import com.ironhack.GardeningStore.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController implements DepartmentControllerInterface {

    @Autowired
    DepartmentRepository departmentRepository;

}
