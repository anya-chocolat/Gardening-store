package com.ironhack.GardeningStore.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@DynamicUpdate
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "department_id")
    private Department department;
    @NotEmpty
    private String name;
    @Min(0)
    @Max(9999)
    private int quantity;

    public Product() {
    }

    public Product(Department department, String name, int quantity) {
        this.department = department;
        this.name = name;
        this.quantity = quantity;
    }
}
