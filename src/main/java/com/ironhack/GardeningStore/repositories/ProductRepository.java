package com.ironhack.GardeningStore.repositories;

import com.ironhack.GardeningStore.entities.Department;
import com.ironhack.GardeningStore.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByDepartmentAndNameAndQuantity(Department department, String name, int quantity);

    List<Product> findByDepartment(Department department);

}
