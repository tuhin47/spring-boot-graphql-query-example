package com.tuhin47.graphql.springbootgrapqlexample2.customers;


import com.tuhin47.graphql.springbootgrapqlexample2.orders.Order;
import com.tuhin47.graphql.springbootgrapqlexample2.orders.data.OrderModel;
import com.tuhin47.graphql.springbootgrapqlexample2.orders.data.OrderRepository;
import com.tuhin47.graphql.springbootgrapqlexample2.products.Product;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerResolver implements GraphQLResolver<Customer> {

    private OrderRepository orderRepository;

    @Autowired
    public CustomerResolver(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> orders(Customer customer) {
        return orderRepository.findByCustomerId(customer.getId())
                .stream()
                .map(this::orderToGraphQL)
                .collect(Collectors.toList());
    }

    private Order orderToGraphQL(OrderModel orderModel) {
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
    }
}
