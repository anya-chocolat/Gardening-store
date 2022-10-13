package com.ironhack.GardeningStore.controller;

import com.ironhack.GardeningStore.DTOs.ProductDTO;
import com.ironhack.GardeningStore.DTOs.QuantityDTO;
import com.ironhack.GardeningStore.controller.interfaces.ProductControllerInterface;
import com.ironhack.GardeningStore.entities.Product;
import com.ironhack.GardeningStore.repositories.ProductRepository;
import com.ironhack.GardeningStore.services.interfaces.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController implements ProductControllerInterface {

    @Autowired
    ProductServiceInterface productService;

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody ProductDTO product){
        return productService.addProduct(product);
    }

    @PatchMapping("/products/quantity")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Product decreaseQuantity(@RequestBody QuantityDTO quantityDTO) {
        return productService.decreaseQuantity(quantityDTO);
    }

    @DeleteMapping("/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id){
        productService.deleteById(id);
    }

    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getProductsByDepartment(@RequestParam Optional<Integer> departmentId){
        return productService.getProductsByDepartment(departmentId);
    }

    @GetMapping("/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProductById(@PathVariable long id) {
        return productService.getProductById(id);
    }


}
