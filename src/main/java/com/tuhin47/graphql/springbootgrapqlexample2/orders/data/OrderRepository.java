package com.tuhin47.graphql.springbootgrapqlexample2.orders.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<OrderModel, Long> {
    List<OrderModel> findByCustomerId(Long customerId);
}
