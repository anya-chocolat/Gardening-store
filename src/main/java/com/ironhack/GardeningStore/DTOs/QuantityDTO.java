package com.ironhack.GardeningStore.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
public class QuantityDTO {
    @NotEmpty
    private long productId;
    @Digits(integer = 4, fraction = 0)
    @Min(0)
    @Max(9999)
    private int quantity;
}
