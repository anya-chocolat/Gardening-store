package com.ironhack.GardeningStore;

import com.ironhack.GardeningStore.entities.Department;
import com.ironhack.GardeningStore.entities.Product;
import com.ironhack.GardeningStore.repositories.DepartmentRepository;
import com.ironhack.GardeningStore.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class GardeningStoreApplication implements CommandLineRunner {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(GardeningStoreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        departmentRepository.saveAll(List.of(
                new Department("tools", new ArrayList<>()),
                new Department("edible plants", new ArrayList<>()),
                new Department("non-edible plants", new ArrayList<>()),
                new Department("edible seeds", new ArrayList<>()),
                new Department("non-edible seeds", new ArrayList<>()),
                new Department("miscellaneous", new ArrayList<>())
        ));

        productRepository.saveAll(List.of(
                new Product(departmentRepository.findById(1).get(), "small shovel", 50),
                new Product(departmentRepository.findById(1).get(), "large shovel", 150),
                new Product(departmentRepository.findById(2).get(), "apple tree sapling", 10),
                new Product(departmentRepository.findById(4).get(), "assorted root vegetable seed packet", 2000),
                new Product(departmentRepository.findById(5).get(), "geranium seed packet", 1000),
                new Product(departmentRepository.findById(2).get(), "sprouted carrots", 200),
                new Product(departmentRepository.findById(6).get(), "large brim gardening hat", 25)

        ));
    }

}
