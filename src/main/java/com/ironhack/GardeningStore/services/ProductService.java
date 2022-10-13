package com.ironhack.GardeningStore.services;

import com.ironhack.GardeningStore.DTOs.ProductDTO;
import com.ironhack.GardeningStore.DTOs.QuantityDTO;
import com.ironhack.GardeningStore.entities.Department;
import com.ironhack.GardeningStore.entities.Product;
import com.ironhack.GardeningStore.repositories.DepartmentRepository;
import com.ironhack.GardeningStore.repositories.ProductRepository;
import com.ironhack.GardeningStore.services.interfaces.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceInterface {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Product addProduct(ProductDTO product) {
        Department department = departmentRepository.findById(product.getDepartmentId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No such department id"));
        if (productRepository.findByDepartmentAndNameAndQuantity(
                department, product.getName(), product.getQuantity()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "This product already exists");
        }
        Product newProduct = new Product(department, product.getName(), product.getQuantity());
        return productRepository.save(newProduct);
    }

    @Override
    public Product decreaseQuantity(QuantityDTO quantityDTO) {
        Product product = productRepository.findById(quantityDTO.getProductId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No such product found"));
        if (product.getQuantity() < quantityDTO.getQuantity()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "The specified amount is greater than the quantity of the product in stock.");
        }
        product.setQuantity(product.getQuantity() - quantityDTO.getQuantity());
        return productRepository.save(product);
    }

    public List<Product> getProductsByDepartment(Optional<Integer> departmentId){
        if (!departmentId.isPresent() || departmentId.isEmpty() || !departmentRepository.findById(departmentId.get()).isPresent()){
            return productRepository.findAll();
        } else {
            return productRepository.findByDepartment(departmentRepository.findById(departmentId.get()).get());
        }
    }
}
