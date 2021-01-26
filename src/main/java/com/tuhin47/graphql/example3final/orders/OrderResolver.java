package com.tuhin47.graphql.example3final.orders;


import com.tuhin47.graphql.example3final.customers.data.Customer;
import com.tuhin47.graphql.example3final.customers.data.CustomerRepository;
import com.tuhin47.graphql.example3final.orders.data.Order;
import com.tuhin47.graphql.example3final.products.data.Product;
import com.tuhin47.graphql.example3final.products.data.ProductRepository;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderResolver implements GraphQLResolver<Order> {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public Customer customer(Order order) {
        return customerRepository.findById(order.getCustomer().getId())
//                .map(this::modelToGraphQL)
                .orElse(null);
    }

    public Product product(Order order) {
        return productRepository.findById(order.getProduct().getId())
//                .map(this::modelToGraphQL)
                .orElse(null);
    }
/*
    private Product modelToGraphQL(Product productModel) {
        Product product = new Product();
        product.setDescription(productModel.getDescription());
        product.setName(productModel.getName());
        product.setId(productModel.getId());
        product.setPrice(productModel.getPrice());
        return product;
    }

    private Customer modelToGraphQL(Customer customerModel) {
        Customer customer = new Customer();
        customer.setEmail(customerModel.getEmail());
        customer.setId(customerModel.getId());
        customer.setName(customerModel.getName());
        return customer;
    }*/

}
