package com.tuhin47.graphql;


import com.tuhin47.graphql.springbootgrapqlexample2.customers.Customer;
import com.tuhin47.graphql.springbootgrapqlexample2.customers.data.CustomerModel;
import com.tuhin47.graphql.springbootgrapqlexample2.customers.data.CustomerRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    private CustomerRepository customerRepository;

    public QueryResolver(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer customerById(Long id) {
        return customerRepository
                .findById(id)
                .map(this::modelToGraphQL)
                .orElse(null);
    }

    private Customer modelToGraphQL(CustomerModel customerModel) {
        Customer customer = new Customer();
        customer.setId(customerModel.getId());
        customer.setName(customerModel.getName());
        customer.setEmail(customerModel.getEmail());

        return customer;
    }
}
