package com.ironhack.GardeningStore.controller.interfaces;

import com.ironhack.GardeningStore.DTOs.ProductDTO;
import com.ironhack.GardeningStore.DTOs.QuantityDTO;
import com.ironhack.GardeningStore.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductControllerInterface {

    Product addProduct(ProductDTO product);

    Product decreaseQuantity(QuantityDTO quantityDTO);

    List<Product> getProductsByDepartment(Optional<Integer> departmentId);

    Product getProductById(long id);

    void deleteById(Long id);

}
