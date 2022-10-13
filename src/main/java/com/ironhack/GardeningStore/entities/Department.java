package com.ironhack.GardeningStore.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@DynamicUpdate
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty
    private String department;
    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private List<Product> products;

    public Department() {
    }

    public Department(String department, List<Product> products) {
        this.department = department;
        this.products = products;
    }
}
