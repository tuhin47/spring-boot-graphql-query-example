package com.tuhin47.graphql;


import com.tuhin47.graphql.example3final.customers.data.Customer;
import com.tuhin47.graphql.example3final.customers.data.CustomerRepository;
import com.tuhin47.graphql.example3final.orders.data.Order;
import com.tuhin47.graphql.example3final.orders.data.OrderRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;

    public QueryResolver(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer customerById(Long id) {
        return customerRepository
                .findById(id)
                .orElse(null);
    }

    public Order orderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    private Customer modelToGraphQL(Customer customerModel) {
        Customer customer = new Customer();
        customer.setId(customerModel.getId());
        customer.setName(customerModel.getName());
        customer.setEmail(customerModel.getEmail());

        return customer;
    }
}
