package com.ironhack.GardeningStore.controller;

import com.ironhack.GardeningStore.controller.interfaces.DepartmentControllerInterface;
import com.ironhack.GardeningStore.entities.Department;
import com.ironhack.GardeningStore.repositories.DepartmentRepository;
import com.ironhack.GardeningStore.services.interfaces.DepartmentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController implements DepartmentControllerInterface {

    @Autowired
    DepartmentServiceInterface departmentService;

    @PostMapping("/departments")
    public Department addDepartment(@RequestParam String department) {
        return departmentService.addDepartment(department);
    }
}
