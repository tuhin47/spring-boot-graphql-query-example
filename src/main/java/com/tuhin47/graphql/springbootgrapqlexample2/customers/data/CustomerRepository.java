package com.tuhin47.graphql.springbootgrapqlexample2.customers.data;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerModel, Long> {

}
