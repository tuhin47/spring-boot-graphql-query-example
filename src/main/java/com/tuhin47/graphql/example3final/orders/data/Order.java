package com.tuhin47.graphql.example3final.orders.data;

import com.tuhin47.graphql.example3final.customers.data.Customer;
import com.tuhin47.graphql.example3final.products.Product;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*@Column(name = "customer_id",nullable = false)
    private Long customerId;

    @Column(name = "product_id",nullable = false)
    private Long productId;*/

    private Integer quantity;

    private String status;

    private LocalDate created;

    @JoinColumn(name = "customer_id")
    @ManyToOne(optional=false,fetch = FetchType.LAZY)
    private Customer customer;

    @JoinColumn(name = "product_id")
    @ManyToOne(optional=false,fetch = FetchType.LAZY)
    private Product product;


}
