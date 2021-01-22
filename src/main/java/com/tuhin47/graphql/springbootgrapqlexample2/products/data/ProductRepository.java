package com.tuhin47.graphql.springbootgrapqlexample2.products.data;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductModel, Long> {
}
