package com.ironhack.GardeningStore.DTOs;

import com.ironhack.GardeningStore.entities.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
public class ProductDTO {
    @Digits(integer = 1, fraction = 0)
    @Min(1L)
    @Max(6L)
    @NotEmpty
    private int departmentId;
    @NotEmpty
    private String name;
    @Digits(integer = 4, fraction = 0)
    @Min(0)
    @Max(9999)
    private int quantity;
}
