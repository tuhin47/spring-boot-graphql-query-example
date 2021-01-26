package com.tuhin47.graphql.example3final.customers;


import com.tuhin47.graphql.example3final.customers.data.Customer;
import com.tuhin47.graphql.example3final.orders.data.Order;
import com.tuhin47.graphql.example3final.orders.data.OrderRepository;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerResolver implements GraphQLResolver<Customer> {

    @Autowired
    private OrderRepository orderRepository;



    public List<Order> orders(Customer customer) {
        return new ArrayList<>(orderRepository.findByCustomerId(customer.getId()));
    }

    /*private Order orderToGraphQL(Order orderModel) {
        Order order = new Order();
        order.setId(orderModel.getId());
        order.setStatus(orderModel.getStatus());
        order.setQuantity(orderModel.getQuantity());
        order.setCreated(orderModel.getCreated());

        Product product = new Product();
        product.setId(orderModel.getProductId());
        order.setProduct(product);

        Customer customer = new Customer();
        customer.setId(orderModel.getCustomerId());
        order.setCustomer(customer);

        return order;
    }*/
}
