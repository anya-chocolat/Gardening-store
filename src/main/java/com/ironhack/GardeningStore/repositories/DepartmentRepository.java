package com.ironhack.GardeningStore.repositories;

import com.ironhack.GardeningStore.entities.Department;
import com.ironhack.GardeningStore.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
