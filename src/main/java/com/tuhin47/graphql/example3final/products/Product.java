package com.tuhin47.graphql.example3final.products;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "products")
public class Product {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private Double price;


}
