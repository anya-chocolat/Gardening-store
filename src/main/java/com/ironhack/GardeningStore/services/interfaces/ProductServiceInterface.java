package com.ironhack.GardeningStore.services.interfaces;

import com.ironhack.GardeningStore.DTOs.ProductDTO;
import com.ironhack.GardeningStore.DTOs.QuantityDTO;
import com.ironhack.GardeningStore.entities.Product;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface ProductServiceInterface {
    Product addProduct(ProductDTO product);

    Product decreaseQuantity(QuantityDTO quantityDTO);

    List<Product> getProductsByDepartment(Optional<Integer> departmentId);

    Product getProductById(long id);

    void deleteById(Long id);

}
