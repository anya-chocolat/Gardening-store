package com.ironhack.GardeningStore.repositories;

import com.ironhack.GardeningStore.entities.Department;
import com.ironhack.GardeningStore.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    // Optional<Department>
    boolean existsByName(String name);
}
